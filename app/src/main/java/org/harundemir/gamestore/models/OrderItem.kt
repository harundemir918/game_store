package org.harundemir.gamestore.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "order_items")
data class OrderItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val orderId: Int,
    val item: CartItem,
    val total: Double,
    val date: String
)
