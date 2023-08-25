package org.harundemir.gamestore.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.harundemir.gamestore.db.GameStoreDatabase
import org.harundemir.gamestore.models.Cart
import org.harundemir.gamestore.repositories.CartRepository

class CartViewModel(application: Application) : AndroidViewModel(application) {
    private val readAllData: LiveData<List<Cart>>
    private val cartRepository: CartRepository

    init {
        val cartDao = GameStoreDatabase.getDatabase(application).cartDao()
        cartRepository = CartRepository(cartDao)
        readAllData = cartRepository.readAllData
    }

    fun addItemToCart(cart: Cart) {
        viewModelScope.launch(Dispatchers.IO) {
            cartRepository.addItemToCart(cart)
        }
    }
}