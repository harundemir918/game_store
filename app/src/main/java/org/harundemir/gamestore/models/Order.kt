package org.harundemir.gamestore.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val userId: Int,
    val code: String,
    val total: Double,
    val date: String
)
