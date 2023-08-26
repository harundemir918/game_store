package org.harundemir.gamestore.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import org.harundemir.gamestore.models.Cart

@Dao
interface CartDao {
    @Upsert
    suspend fun upsertCartItem(cart: Cart)

    @Delete
    suspend fun deleteCartItem(cart: Cart)

    @Query("SELECT * FROM cart")
    fun readAllData(): LiveData<List<Cart>>

    @Query("SELECT * from cart WHERE itemId = :itemId")
    fun getCartItemByItemId(itemId: Int): Cart?
}