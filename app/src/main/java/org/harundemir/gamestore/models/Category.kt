package org.harundemir.gamestore.models

import java.io.Serializable

data class Category(
    val title: String,
    val icon: Int
) : Serializable
