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
    fun `Check if cart item can be retrieved with item id`() = runBlocking {
        val id = Random.nextInt(1, 6)
        val item = fakeRepository.getCartItemByItemId(id)
        assert(item != null)
    }

    @Test
    fun `Check if cart can be cleared`() = runBlocking {
        fakeRepository.clearCart()
        assert(fakeRepository.cart.isEmpty())
    }
}