package org.harundemir.gamestore.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import org.harundemir.gamestore.models.CartItem

class FakeCartRepositoryImpl : CartRepository {
    val cart = mutableListOf<CartItem>()

    override val getAllCartItems: LiveData<List<CartItem>>
        get() = MediatorLiveData(cart)

    override suspend fun addItemToCart(cartItem: CartItem) {
        val item = cart.find { it.id == cartItem.id }
        if (item == null) {
            cart.add(cartItem)
        } else {
            val itemPosition = cart.indexOfFirst { it.id == cartItem.id }
            cart[itemPosition] = cartItem
        }
    }

    override suspend fun deleteCartItem(cartItem: CartItem) {
        cart.remove(cartItem)
    }

    override fun getCartItemByItemId(itemId: Int): CartItem? {
        return cart.find { it.itemId == itemId }
    }

    override suspend fun clearCart() {
        cart.clear()
    }
}