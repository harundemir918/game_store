package org.harundemir.gamestore.repositories

import androidx.lifecycle.LiveData
import org.harundemir.gamestore.db.dao.CartDao
import org.harundemir.gamestore.models.Cart

class CartRepository(private val cartDao: CartDao) {
    val readAllData: LiveData<List<Cart>> = cartDao.readAllData()

    suspend fun addItemToCart(cart: Cart) {
        cartDao.upsertCartItem(cart)
    }

    suspend fun deleteCartItem(cart: Cart) {
        cartDao.deleteCartItem(cart)
    }
}