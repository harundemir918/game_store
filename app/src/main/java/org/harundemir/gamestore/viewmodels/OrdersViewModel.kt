package org.harundemir.gamestore.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.harundemir.gamestore.db.GameStoreDatabase
import org.harundemir.gamestore.models.CartItem
import org.harundemir.gamestore.models.Order
import org.harundemir.gamestore.models.OrderItem
import org.harundemir.gamestore.repositories.OrderItemsRepository
import org.harundemir.gamestore.repositories.OrdersRepository
import org.harundemir.gamestore.utils.Utils
import javax.inject.Inject

@HiltViewModel
class OrdersViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {
    private val ordersRepository: OrdersRepository
    private val orderItemsRepository: OrderItemsRepository
    private var _orderItems: MutableLiveData<List<Order>> = MutableLiveData()
    var orderItems: LiveData<List<Order>> = _orderItems

    init {
        val ordersDao = GameStoreDatabase.getDatabase(application).ordersDao()
        val orderItemsDao = GameStoreDatabase.getDatabase(application).orderItemsDao()
        ordersRepository = OrdersRepository(ordersDao)
        orderItemsRepository = OrderItemsRepository(orderItemsDao)
        ordersRepository.getAllOrders.observeForever { newOrderItems ->
            _orderItems.value = newOrderItems
        }
    }

    fun addOrder(cartItems: List<CartItem>) {
        viewModelScope.launch(Dispatchers.IO) {
            val orderCode = Utils.generateOrderCode()
            val date = java.time.Instant.now().toString()
            val order = Order(
                userId = 1,
                code = orderCode,
                date = date,
                total = 0.0
            )
            addOrUpdateOrder(order)
            val getOrder =
                getOrderByUserIdAndCode(userId = order.userId, code = order.code)
            if (getOrder != null) {
                addOrderItem(order = getOrder, cartItems = cartItems)
            }
        }
    }

    private fun addOrderItem(order: Order, cartItems: List<CartItem>) {
        viewModelScope.launch(Dispatchers.IO) {
            val total = cartItems.sumOf { it.total }
            for (item in cartItems) {
                val orderItem = OrderItem(
                    orderId = order.id!!,
                    item = item,
                    total = item.total,
                    date = order.date,
                )
                orderItemsRepository.addOrderItem(orderItem)
            }
            val updatedOrder = order.copy(total = total)
            addOrUpdateOrder(updatedOrder)
        }
    }

    private suspend fun addOrUpdateOrder(order: Order) {
        ordersRepository.addOrder(order)
    }

    fun getOrderById(id: Int): Order? {
        return ordersRepository.getOrderById(id)
    }

    fun getOrdersByUserId(userId: Int): List<Order> {
        return ordersRepository.getOrdersByUserId(userId)
    }

    private fun getOrderByUserIdAndCode(userId: Int, code: String): Order? {
        return ordersRepository.getOrderByUserIdAndCode(userId, code)
    }
}