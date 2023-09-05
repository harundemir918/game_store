package org.harundemir.gamestore.viewmodels

import kotlinx.coroutines.runBlocking
import org.harundemir.gamestore.data.gameList
import org.harundemir.gamestore.models.CartItem
import org.harundemir.gamestore.repositories.FakeCartRepositoryImpl
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

class CartViewModelTest {
    private lateinit var fakeRepository: FakeCartRepositoryImpl

    @Before
    fun setUp() {
        fakeRepository = FakeCartRepositoryImpl()

        val cart = mutableListOf<CartItem>()
        val quantity = Random.nextInt(1, 6)
        for (index in 0..4) {
            cart.add(
                CartItem(
                    id = index,
                    itemId = gameList[index].id,
                    item = gameList[index],
                    quantity = quantity,
                    total = gameList[index].price * quantity,
                )
            )
        }
        runBlocking {
            cart.forEach { fakeRepository.addItemToCart(it) }
        }
    }

    @Test
    fun `Check if cart has items`() {
        assert(fakeRepository.cart.isNotEmpty())
    }

    @Test
    fun `Check if an item can be added to cart`() = runBlocking {
        val id = Random.nextInt(1, 20)
        val game = gameList[0]
        val existingItem = fakeRepository.getCartItemByItemId(id)
        if (existingItem != null) {
            val incrementedQuantity = existingItem.quantity + 1
            val newTotal = incrementedQuantity * existingItem.item.price
            val updatedItem =
                existingItem.copy(quantity = incrementedQuantity, total = newTotal)
            fakeRepository.addItemToCart(updatedItem)
            assert(fakeRepository.cart.last().id == existingItem.id)
        } else {
            val cartItem =
                CartItem(
                    id = fakeRepository.cart.last().id!! + 1,
                    itemId = game.id,
                    item = game,
                    quantity = 1,
                    total = game.price
                )
            fakeRepository.addItemToCart(cartItem)
            assert(fakeRepository.cart.last().id == cartItem.id)
        }
    }

    @Test
    fun `Check if cart item can be retrieved with item id`() = runBlocking {
        val id = Random.nextInt(1, 6)
        val item = fakeRepository.getCartItemByItemId(id)
        assert(item != null)
    }

    @Test
    fun `Check if item quantity can be incremented`() = runBlocking {
        val cartItem = fakeRepository.cart.first()
        val updatedQuantity = cartItem.quantity + 1
        val newTotal = updatedQuantity * cartItem.item.price
        val updatedItem =
            cartItem.copy(quantity = updatedQuantity, total = newTotal)
        fakeRepository.addItemToCart(updatedItem)
        assert(fakeRepository.cart.find { it.id == cartItem.id }!!.quantity == updatedQuantity)
    }

    @Test
    fun `Check if item quantity can be decremented or item can be deleted`() = runBlocking{
        val cartItem = fakeRepository.cart.first()
        if (cartItem.quantity > 1) {
            val updatedQuantity = cartItem.quantity - 1
            val newTotal = updatedQuantity * cartItem.item.price
            val updatedItem =
                cartItem.copy(quantity = updatedQuantity, total = newTotal)
            fakeRepository.addItemToCart(updatedItem)
            assert(fakeRepository.cart.find { it.id == cartItem.id }!!.quantity == updatedQuantity)
        } else {
            fakeRepository.deleteCartItem(cartItem)
            assert(fakeRepository.cart.find { it.id == cartItem.id } == null)
        }

    }

    @Test
    fun `Check if cart can be cleared`() = runBlocking {
        fakeRepository.clearCart()
        assert(fakeRepository.cart.isEmpty())
    }
}