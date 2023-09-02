package org.harundemir.gamestore.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val userId: Int,
    val code: String,
    val item: CartItem,
    val date: String
)
