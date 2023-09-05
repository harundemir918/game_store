package org.harundemir.gamestore.activities


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.harundemir.gamestore.R
import org.harundemir.gamestore.adapters.OrderDetailAdapter
import org.harundemir.gamestore.databinding.ActivityOrderDetailBinding
import org.harundemir.gamestore.models.Order
import org.harundemir.gamestore.utils.Utils
import org.harundemir.gamestore.viewmodels.OrdersViewModel

class OrderDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderDetailBinding
    private val ordersViewModel: OrdersViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.orderDetailToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        val order = intent.getSerializableExtra("order") as? Order

        binding.orderDetailCode.text = order!!.code
        binding.orderDetailDate.text = Utils.getFormattedDateTime(order.date)
        binding.orderDetailTotal.text = getString(R.string.total_with_value, order.total.toString())

        val orderDetailAdapter = OrderDetailAdapter()
        val orderList = ordersViewModel.getOrderItemsByOrderId(order.id!!)
        orderList.observe(this) { items ->
            orderDetailAdapter.setData(items)
        }
        binding.orderDetailList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.orderDetailList.adapter = orderDetailAdapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}