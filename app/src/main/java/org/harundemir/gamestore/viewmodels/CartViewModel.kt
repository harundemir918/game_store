package org.harundemir.gamestore.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.harundemir.gamestore.db.GameStoreDatabase
import org.harundemir.gamestore.models.Cart
import org.harundemir.gamestore.models.Game
import org.harundemir.gamestore.repositories.CartRepository

class CartViewModel(application: Application) : AndroidViewModel(application) {
    private val _cartItems: MutableLiveData<List<Cart>> = MutableLiveData()
    val cartItems: LiveData<List<Cart>> = _cartItems
    private val cartRepository: CartRepository
    private val _totalItemsPrice = MediatorLiveData<Double>()
    val totalItemsPrice: LiveData<Double> = _totalItemsPrice

    init {
        val cartDao = GameStoreDatabase.getDatabase(application).cartDao()
        cartRepository = CartRepository(cartDao)
        cartRepository.getAllCartItems.observeForever { newCartItems ->
            _cartItems.value = newCartItems
        }
        _totalItemsPrice.addSource(cartItems) { cartItems ->
            if (cartItems.isEmpty()) {
                _totalItemsPrice.postValue(0.0)
            } else {
                updateTotalPrice()
            }
        }
    }

    fun addItemToCart(game: Game) {
        viewModelScope.launch(Dispatchers.IO) {
            val existingItem = getCartItemByItemId(game.id)
            if (existingItem != null) {
                val updatedItem = existingItem.copy(quantity = existingItem.quantity + 1)
                cartRepository.addItemToCart(updatedItem)
            } else {
                val cartItem = Cart(itemId = game.id, item = game, quantity = 1)
                cartRepository.addItemToCart(cartItem)
            }
            updateTotalPrice()
        }
    }

    private fun getCartItemByItemId(itemId: Int): Cart? {
        return cartRepository.getCartItemByItemId(itemId)
    }

    fun deleteCartItem(cartItem: Cart) {
        viewModelScope.launch(Dispatchers.IO) {
            cartRepository.deleteCartItem(cartItem)
        }
        updateTotalPrice()
    }

    fun incrementCartItemQuantity(cartItem: Cart) {
        viewModelScope.launch(Dispatchers.IO) {
            cartRepository.incrementCartItemQuantity(cartItem.id!!)
        }
    }

    fun decrementCartItemQuantity(cartItem: Cart) {
        viewModelScope.launch(Dispatchers.IO) {
            if (cartItem.quantity > 1) {
                cartRepository.decrementCartItemQuantity(cartItem.id!!)
            } else {
                deleteCartItem(cartItem)
            }
        }
    }

    fun updateTotalPrice() {
        val totalPrice = calculateTotalPrice(cartItems.value)
        _totalItemsPrice.postValue(totalPrice)
    }

    private fun calculateTotalPrice(cartItems: List<Cart>?): Double {
        var totalPrice = 0.0
        cartItems?.forEach { cartItem ->
            totalPrice += cartItem.item.price * cartItem.quantity
        }
        return totalPrice
    }
}