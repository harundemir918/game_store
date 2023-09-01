package org.harundemir.gamestore.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import org.harundemir.gamestore.models.Transaction

@Dao
interface TransactionsDao {
    @Query("SELECT * FROM `transaction`")
    fun getAllTransactions(): List<Transaction>

    @Upsert
    suspend fun addTransaction(transaction: Transaction)

    @Query("SELECT * FROM `transaction` WHERE id = :id")
    fun getTransactionById(id: Int): Transaction?

    @Query("SELECT * FROM `transaction` WHERE userId = :userId")
    fun getTransactionsByUserId(userId: Int): List<Transaction>
}