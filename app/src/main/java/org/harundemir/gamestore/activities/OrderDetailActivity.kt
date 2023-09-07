package org.harundemir.gamestore.activities


import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Paint
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
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
    private var permissionCode = 101
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
        binding.orderDetailBill.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        val orderDetailAdapter = OrderDetailAdapter()
        val orderList = ordersViewModel.getOrderItemsByOrderId(order.id!!)
        orderList.observe(this) { items ->
            orderDetailAdapter.setData(items)
        }
        binding.orderDetailList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.orderDetailList.adapter = orderDetailAdapter

        binding.orderDetailBill.setOnClickListener {
            if (checkStoragePermission()) {
                Utils.createPDF(context = this, order = order, orderItems = orderList.value!!)
            } else {
                requestStoragePermission()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun checkStoragePermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            true
        } else {
            val writeStoragePermission = ContextCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            val readStoragePermission = ContextCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
            writeStoragePermission == PackageManager.PERMISSION_GRANTED && readStoragePermission == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun requestStoragePermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ),
            permissionCode
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == permissionCode) {
            if (grantResults.isNotEmpty()) {
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED || grantResults[1] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, getString(R.string.permission_denied), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}