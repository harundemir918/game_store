package org.harundemir.gamestore.repositories

import androidx.lifecycle.LiveData
import org.harundemir.gamestore.db.dao.CartDao
import org.harundemir.gamestore.models.CartItem

class CartRepositoryImpl(private val cartDao: CartDao) : CartRepository {
    override val getAllCartItems: LiveData<List<CartItem>> = cartDao.getAllCartItems()

    override suspend fun addItemToCart(cartItem: CartItem) {
        cartDao.upsertCartItem(cartItem)
    }

    override suspend fun deleteCartItem(cartItem: CartItem) {
        cartDao.deleteCartItem(cartItem)
    }

    override fun getCartItemByItemId(itemId: Int): CartItem? {
        return cartDao.getCartItemByItemId(itemId)
    }

    override suspend fun clearCart() {
        return cartDao.clearCart()
    }
}