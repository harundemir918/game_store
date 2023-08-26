package org.harundemir.gamestore.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.harundemir.gamestore.db.GameStoreDatabase
import org.harundemir.gamestore.models.Cart
import org.harundemir.gamestore.models.Game
import org.harundemir.gamestore.repositories.CartRepository

class CartViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<Cart>>
    private val cartRepository: CartRepository

    init {
        val cartDao = GameStoreDatabase.getDatabase(application).cartDao()
        cartRepository = CartRepository(cartDao)
        readAllData = cartRepository.readAllData
    }

    fun addItemToCart(game: Game) {
        viewModelScope.launch(Dispatchers.IO) {
            val existingItem = getCartItemByItemId(game.id)
            if (existingItem != null) {
                val updatedItem = existingItem.copy(piece = existingItem.piece + 1)
                cartRepository.addItemToCart(updatedItem)
            } else {
                val cartItem = Cart(itemId = game.id, item = game, piece = 1)
                cartRepository.addItemToCart(cartItem)
            }
        }
    }

    private fun getCartItemByItemId(itemId: Int): Cart? {
        return cartRepository.getCartItemByItemId(itemId)
    }
}