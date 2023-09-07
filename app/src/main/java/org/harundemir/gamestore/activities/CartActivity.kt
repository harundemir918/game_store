package org.harundemir.gamestore.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import org.harundemir.gamestore.R
import org.harundemir.gamestore.adapters.CartAdapter
import org.harundemir.gamestore.databinding.ActivityCartBinding
import org.harundemir.gamestore.viewmodels.CartViewModel
import org.harundemir.gamestore.viewmodels.OrdersViewModel

@AndroidEntryPoint
class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding
    private val cartViewModel: CartViewModel by viewModels()
    private val ordersViewModel: OrdersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.cartToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        binding.cartItemList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val cartAdapter = CartAdapter(
            onDeleteClicked = { cartItem ->
                cartViewModel.deleteCartItem(cartItem)
            },
            onAddClicked = { cartItem ->
                cartViewModel.incrementCartItemQuantity(cartItem)
            },
            onSubtractClicked = { cartItem ->
                cartViewModel.decrementCartItemQuantity(cartItem)
            },
        )
        binding.cartItemList.adapter = cartAdapter
        cartViewModel.cartItems.observe(this) { items ->
            if (items.isEmpty()) {
                cartAdapter.setData(emptyList())
                binding.cartNoItemsFound.isVisible = true
            } else {
                cartAdapter.setData(items)
                cartViewModel.updateTotalPrice()
                binding.cartNoItemsFound.isVisible = false
            }
        }

        cartViewModel.cartSubtotal.observe(this) { subtotal ->
            binding.cartSubtotal.text = getString(R.string.total_with_value, subtotal.toString())
        }
        cartViewModel.cartTax.observe(this) { tax ->
            binding.cartTax.text = getString(R.string.total_with_value, tax.toString())
        }
        cartViewModel.cartTotal.observe(this) { totalPrice ->
            binding.cartBuy.text = getString(R.string.buy_now, totalPrice.toString())
        }

        binding.cartBuy.setOnClickListener {
            if (cartViewModel.cartItems.value!!.isNotEmpty()) {
                ordersViewModel.addOrder(cartViewModel.cartItems.value!!)
                cartViewModel.clearCart()
                Toast.makeText(this, getString(R.string.purchase_is_successful), Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, getString(R.string.cart_is_empty), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}