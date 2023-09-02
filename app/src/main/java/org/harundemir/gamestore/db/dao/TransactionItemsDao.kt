package org.harundemir.gamestore.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import org.harundemir.gamestore.models.TransactionItem

@Dao
interface TransactionItemsDao {
    @Query("SELECT * FROM transaction_items")
    fun getAllTransactionItems(): LiveData<List<TransactionItem>>

    @Upsert
    suspend fun addTransactionItem(transactionItem: TransactionItem)

    @Query("SELECT * FROM transaction_items WHERE id = :id")
    fun getTransactionItemById(id: Int): TransactionItem?
}