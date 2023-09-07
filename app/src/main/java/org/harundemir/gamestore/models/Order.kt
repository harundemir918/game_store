package org.harundemir.gamestore.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val userId: Int,
    val code: String,
    val subtotal: Double,
    val tax: Double,
    val total: Double,
    val date: String
) : Serializable
