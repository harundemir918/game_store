package org.harundemir.gamestore.models

import java.io.Serializable

data class Game(
    val id: Int,
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
