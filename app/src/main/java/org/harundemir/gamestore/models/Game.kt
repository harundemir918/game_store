package org.harundemir.gamestore.models

data class Game(
    val id: Int,
    val title: String,
    val cover: Int,
    val avatar: Int,
    val category: Category,
    val rate: Double,
    val size: Double,
    val images: List<Int>
)
