package org.harundemir.gamestore.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import org.harundemir.gamestore.models.Transaction

@Dao
interface TransactionsDao {
    @Query("SELECT * FROM transactions")
    fun getAllTransactions(): LiveData<List<Transaction>>

    @Upsert
    suspend fun addTransaction(transaction: Transaction)

    @Query("SELECT * FROM transactions WHERE id = :id")
    fun getTransactionById(id: Int): Transaction?

    @Query("SELECT * FROM transactions WHERE userId = :userId")
    fun getTransactionsByUserId(userId: Int): List<Transaction>

    @Query("SELECT * FROM transactions WHERE userId = :userId AND code = :code")
    fun getTransactionByUserIdAndCode(userId: Int, code: String): Transaction?
}