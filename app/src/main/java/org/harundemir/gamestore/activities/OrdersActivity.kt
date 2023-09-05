package org.harundemir.gamestore.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import org.harundemir.gamestore.adapters.OrdersAdapter
import org.harundemir.gamestore.databinding.ActivityOrdersBinding
import org.harundemir.gamestore.viewmodels.OrdersViewModel

class OrdersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrdersBinding
    private val ordersViewModel: OrdersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrdersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.ordersToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        val ordersAdapter = OrdersAdapter()
        binding.ordersList.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )
        binding.ordersList.adapter = ordersAdapter
        ordersViewModel.orderItems.observe(this) { items ->
            if (items.isEmpty()) {
                ordersAdapter.setData(emptyList())
                binding.ordersNoItemsFound.isVisible = true
            } else {
                ordersAdapter.setData(items)
                binding.ordersNoItemsFound.isVisible = false
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}