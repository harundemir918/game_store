package org.harundemir.gamestore.models

import java.io.Serializable

data class Category(
    val id: Int,
    val title: String,
    val cover: Int,
    val icon: Int,
) : Serializable
