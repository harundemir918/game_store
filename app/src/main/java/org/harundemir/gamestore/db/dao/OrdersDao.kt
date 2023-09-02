package org.harundemir.gamestore.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import org.harundemir.gamestore.models.Order

@Dao
interface OrdersDao {
    @Query("SELECT * FROM orders")
    fun getAllOrders(): LiveData<List<Order>>

    @Upsert
    suspend fun addOrder(order: Order)

    @Query("SELECT * FROM orders WHERE id = :id")
    fun getOrderById(id: Int): Order?

    @Query("SELECT * FROM orders WHERE userId = :userId")
    fun getOrdersByUserId(userId: Int): List<Order>

    @Query("SELECT * FROM orders WHERE userId = :userId AND code = :code")
    fun getOrderByUserIdAndCode(userId: Int, code: String): Order?
}