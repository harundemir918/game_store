package org.harundemir.gamestore.repositories

import androidx.lifecycle.LiveData
import org.harundemir.gamestore.db.dao.CartDao
import org.harundemir.gamestore.models.Cart

class CartRepository(private val cartDao: CartDao) {
    val getAllCartItems: LiveData<List<Cart>> = cartDao.getAllCartItems()

    suspend fun addItemToCart(cart: Cart) {
        cartDao.upsertCartItem(cart)
    }

    suspend fun deleteCartItem(cart: Cart) {
        cartDao.deleteCartItem(cart)
    }

    fun getCartItemByItemId(itemId: Int): Cart? {
        return cartDao.getCartItemByItemId(itemId)
    }
}