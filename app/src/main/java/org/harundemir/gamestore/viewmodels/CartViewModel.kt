package org.harundemir.gamestore.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.harundemir.gamestore.db.GameStoreDatabase
import org.harundemir.gamestore.models.CartItem
import org.harundemir.gamestore.models.Game
import org.harundemir.gamestore.repositories.CartRepository
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {
    private val cartRepository: CartRepository
    private val _cartItems: MutableLiveData<List<CartItem>> = MutableLiveData()
    val cartItems: LiveData<List<CartItem>> = _cartItems
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
                val incrementedQuantity = existingItem.quantity + 1
                val newTotal = incrementedQuantity * existingItem.item.price
                val updatedItem =
                    existingItem.copy(quantity = incrementedQuantity, total = newTotal)
                cartRepository.addItemToCart(updatedItem)
            } else {
                val cartItem =
                    CartItem(itemId = game.id, item = game, quantity = 1, total = game.price)
                cartRepository.addItemToCart(cartItem)
            }
            updateTotalPrice()
        }
    }

    private fun getCartItemByItemId(itemId: Int): CartItem? {
        return cartRepository.getCartItemByItemId(itemId)
    }

    fun deleteCartItem(cartItem: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            cartRepository.deleteCartItem(cartItem)
        }
        updateTotalPrice()
    }

    fun incrementCartItemQuantity(cartItem: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            cartRepository.incrementCartItemQuantity(cartItem.id!!)
        }
    }

    fun decrementCartItemQuantity(cartItem: CartItem) {
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

    private fun calculateTotalPrice(cartItems: List<CartItem>?): Double {
        var totalPrice = 0.0
        cartItems?.forEach { cartItem ->
            totalPrice += cartItem.item.price * cartItem.quantity
        }
        return totalPrice
    }

    fun clearCart() {
        viewModelScope.launch(Dispatchers.IO) {
            cartRepository.clearCart()
        }
    }
}