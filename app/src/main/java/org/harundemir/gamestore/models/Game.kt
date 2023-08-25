package org.harundemir.gamestore.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Game(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String,
    val cover: Int,
    val avatar: Int,
    val category: Category,
    val description: String,
    val price: Double,
    val rate: Double,
    val size: Double,
    val images: List<Int>
) : Serializable
