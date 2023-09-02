package org.harundemir.gamestore.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import org.harundemir.gamestore.models.CartItem

@Dao
interface CartDao {
    @Upsert
    suspend fun upsertCartItem(cartItem: CartItem)

    @Delete
    suspend fun deleteCartItem(cartItem: CartItem)

    @Query("SELECT * FROM cart")
    fun getAllCartItems(): LiveData<List<CartItem>>

    @Query("SELECT * from cart WHERE itemId = :itemId")
    fun getCartItemByItemId(itemId: Int): CartItem?

    @Query("UPDATE cart SET quantity = quantity + 1 WHERE id = :id")
    suspend fun incrementCartItemQuantity(id: Int)

    @Query("UPDATE cart SET quantity = quantity - 1 WHERE id = :id")
    suspend fun decrementCartItemQuantity(id: Int)

    @Query("DELETE FROM cart")
    suspend fun clearCart()
}