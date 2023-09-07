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
import org.harundemir.gamestore.repositories.CartRepositoryImpl
import org.harundemir.gamestore.utils.Utils
import org.harundemir.gamestore.utils.Utils.taxRate
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {
    private val cartRepository: CartRepository
    private val _cartItems: MutableLiveData<List<CartItem>> = MutableLiveData()
    val cartItems: LiveData<List<CartItem>> = _cartItems
    private val _cartSubtotal = MediatorLiveData<Double>()
    val cartSubtotal: LiveData<Double> = _cartSubtotal
    private val _cartTax = MediatorLiveData<Double>()
    val cartTax: LiveData<Double> = _cartTax
    private val _cartTotal = MediatorLiveData<Double>()
    val cartTotal: LiveData<Double> = _cartTotal

    init {
        val cartDao = GameStoreDatabase.getDatabase(application).cartDao()
        cartRepository = CartRepositoryImpl(cartDao)
        cartRepository.getAllCartItems.observeForever { newCartItems ->
            _cartItems.value = newCartItems
        }
        _cartTotal.addSource(cartItems) { cartItems ->
            if (cartItems.isEmpty()) {
                _cartSubtotal.postValue(0.0)
                _cartTax.postValue(0.0)
                _cartTotal.postValue(0.0)
            } else {
                updateTotalPrice()
            }
        }
    }

    fun addItemToCart(game: Game) {
        viewModelScope.launch(Dispatchers.IO) {
            val existingItem = getCartItemByItemId(game.id)
            if (existingItem != null) {
                val updatedQuantity = existingItem.quantity + 1
                val newTotal = updatedQuantity * existingItem.item.price
                val updatedItem =
                    existingItem.copy(quantity = updatedQuantity, total = newTotal)
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
            val updatedQuantity = cartItem.quantity + 1
            val newTotal = updatedQuantity * cartItem.item.price
            val updatedItem =
                cartItem.copy(quantity = updatedQuantity, total = newTotal)
            cartRepository.addItemToCart(updatedItem)
        }
    }

    fun decrementCartItemQuantity(cartItem: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            if (cartItem.quantity > 1) {
                val updatedQuantity = cartItem.quantity - 1
                val newTotal = updatedQuantity * cartItem.item.price
                val updatedItem =
                    cartItem.copy(quantity = updatedQuantity, total = newTotal)
                cartRepository.addItemToCart(updatedItem)
            } else {
                deleteCartItem(cartItem)
            }
        }
    }

    fun updateTotalPrice() {
        val totalPrice = calculateTotalPrice(cartItems.value)
        _cartTotal.postValue(totalPrice)
    }

    private fun calculateTotalPrice(cartItems: List<CartItem>?): Double {
        var subtotal = 0.0
        cartItems?.forEach { cartItem ->
            subtotal += cartItem.total
        }
        val tax: Double = Utils.roundToTwoDecimalPlaces(subtotal * taxRate)
        val total: Double = subtotal + tax
        _cartSubtotal.postValue(subtotal)
        _cartTax.postValue(tax)
        return total
    }

    fun clearCart() {
        viewModelScope.launch(Dispatchers.IO) {
            cartRepository.clearCart()
        }
    }
}