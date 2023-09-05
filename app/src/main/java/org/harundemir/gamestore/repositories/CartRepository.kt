package org.harundemir.gamestore.repositories

import androidx.lifecycle.LiveData
import org.harundemir.gamestore.models.CartItem

interface CartRepository {
    val getAllCartItems: LiveData<List<CartItem>>

    suspend fun addItemToCart(cartItem: CartItem)

    suspend fun deleteCartItem(cartItem: CartItem)

    fun getCartItemByItemId(itemId: Int): CartItem?

    suspend fun clearCart()
}