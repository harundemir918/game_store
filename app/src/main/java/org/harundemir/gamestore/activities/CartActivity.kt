package org.harundemir.gamestore.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.harundemir.gamestore.R
import org.harundemir.gamestore.adapters.CartAdapter
import org.harundemir.gamestore.databinding.ActivityCartBinding
import org.harundemir.gamestore.viewmodels.CartViewModel

class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding
    private lateinit var cartViewModel: CartViewModel
    private var total: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.cartToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        val cartAdapter = CartAdapter()
        binding.cartItemList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.cartItemList.adapter = cartAdapter

        cartViewModel = ViewModelProvider(this)[CartViewModel::class.java]
        cartViewModel.readAllData.observe(this) { items ->
            for (item in items) {
                total += (item.item.price * item.piece)
            }
            cartAdapter.setData(items)
            binding.cartBuy.text = getString(R.string.buy_now, total.toString())
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}