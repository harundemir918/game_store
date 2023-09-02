package org.harundemir.gamestore.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class CartItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val itemId: Int,
    val item: Game,
    val quantity: Int
)
