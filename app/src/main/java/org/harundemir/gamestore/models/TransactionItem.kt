package org.harundemir.gamestore.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transaction_items")
data class TransactionItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val transactionId: Int,
    val item: CartItem,
    val total: Double,
    val date: String
)
