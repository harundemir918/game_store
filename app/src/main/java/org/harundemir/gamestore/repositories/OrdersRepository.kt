package org.harundemir.gamestore.repositories

import androidx.lifecycle.LiveData
import org.harundemir.gamestore.db.dao.OrdersDao
import org.harundemir.gamestore.models.Order

class OrdersRepository(private val ordersDao: OrdersDao) {
    val getAllOrders: LiveData<List<Order>> = ordersDao.getAllOrders()

    suspend fun addOrder(order: Order) {
        ordersDao.addOrder(order)
    }

    fun getOrderById(id: Int): Order? {
        return ordersDao.getOrderById(id)
    }

    fun getOrdersByUserId(userId: Int): List<Order> {
        return ordersDao.getOrdersByUserId(userId)
    }

    fun getOrderByUserIdAndCode(userId: Int, code: String): Order? {
        return ordersDao.getOrderByUserIdAndCode(userId, code)
    }
}