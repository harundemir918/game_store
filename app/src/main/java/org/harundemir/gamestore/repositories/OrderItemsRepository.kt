package org.harundemir.gamestore.repositories

import androidx.lifecycle.LiveData
import org.harundemir.gamestore.db.dao.OrderItemsDao
import org.harundemir.gamestore.models.OrderItem

class OrderItemsRepository(private val orderItemsDao: OrderItemsDao) {
    val getAllOrderItems: LiveData<List<OrderItem>> =
        orderItemsDao.getAllOrderItems()

    suspend fun addOrderItem(orderItem: OrderItem) {
        orderItemsDao.addOrderItem(orderItem)
    }

    fun getOrderItemById(id: Int): OrderItem? {
        return orderItemsDao.getOrderItemById(id)
    }

    fun getOrderItemsByOrderId(orderId: Int): LiveData<List<OrderItem>> {
        return orderItemsDao.getOrderItemsByOrderId(orderId)
    }
}