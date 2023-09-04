package org.harundemir.gamestore.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import org.harundemir.gamestore.models.OrderItem

@Dao
interface OrderItemsDao {
    @Query("SELECT * FROM order_items")
    fun getAllOrderItems(): LiveData<List<OrderItem>>

    @Upsert
    suspend fun addOrderItem(orderItem: OrderItem)

    @Query("SELECT * FROM order_items WHERE id = :id")
    fun getOrderItemById(id: Int): OrderItem?

    @Query("SELECT * FROM order_items WHERE orderId = :orderId")
    fun getOrderItemsByOrderId(orderId: Int): LiveData<List<OrderItem>>
}