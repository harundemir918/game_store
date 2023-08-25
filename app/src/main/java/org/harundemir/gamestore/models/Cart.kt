package org.harundemir.gamestore.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cart(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val item: Game,
    val piece: Int
)
