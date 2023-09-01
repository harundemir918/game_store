package org.harundemir.gamestore.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.harundemir.gamestore.R
import org.harundemir.gamestore.adapters.CartAdapter
import org.harundemir.gamestore.databinding.ActivityCartBinding
import org.harundemir.gamestore.viewmodels.CartViewModel

class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding
    private lateinit var cartViewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.cartToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
        cartViewModel = ViewModelProvider(this)[CartViewModel::class.java]

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

        cartViewModel.totalItemsPrice.observe(this) { totalPrice ->
            binding.cartBuy.text = getString(R.string.buy_now, totalPrice.toString())
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}