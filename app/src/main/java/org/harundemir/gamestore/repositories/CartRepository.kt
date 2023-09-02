package org.harundemir.gamestore.repositories

import androidx.lifecycle.LiveData
import org.harundemir.gamestore.db.dao.CartDao
import org.harundemir.gamestore.models.CartItem

class CartRepository(private val cartDao: CartDao) {
    val getAllCartItems: LiveData<List<CartItem>> = cartDao.getAllCartItems()

    suspend fun addItemToCart(cartItem: CartItem) {
        cartDao.upsertCartItem(cartItem)
    }

    suspend fun deleteCartItem(cartItem: CartItem) {
        cartDao.deleteCartItem(cartItem)
    }

    fun getCartItemByItemId(itemId: Int): CartItem? {
        return cartDao.getCartItemByItemId(itemId)
    }

    suspend fun incrementCartItemQuantity(id: Int) {
        return cartDao.incrementCartItemQuantity(id)
    }

    suspend fun decrementCartItemQuantity(id: Int) {
        return cartDao.decrementCartItemQuantity(id)
    }

    suspend fun clearCart() {
        return cartDao.clearCart()
    }
}