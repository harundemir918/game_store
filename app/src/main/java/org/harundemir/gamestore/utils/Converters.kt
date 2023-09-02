package org.harundemir.gamestore.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.harundemir.gamestore.models.CartItem
import org.harundemir.gamestore.models.Game

object Converters {
    private val gson = Gson()

    @TypeConverter
    fun gameToJson(game: Game): String {
        return gson.toJson(game)
    }

    @TypeConverter
    fun jsonToGame(json: String): Game {
        val type = object : TypeToken<Game>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun cartToJson(cartItem: CartItem): String {
        return gson.toJson(cartItem)
    }

    @TypeConverter
    fun jsonToCart(json: String): CartItem {
        val type = object : TypeToken<CartItem>() {}.type
        return gson.fromJson(json, type)
    }
}