package org.harundemir.gamestore.repositories

import androidx.lifecycle.LiveData
import org.harundemir.gamestore.db.dao.TransactionsDao
import org.harundemir.gamestore.models.Transaction

class TransactionsRepository(private val transactionsDao: TransactionsDao) {
    val getAllTransactions: LiveData<List<Transaction>> = transactionsDao.getAllTransactions()

    suspend fun addTransaction(transaction: Transaction) {
        transactionsDao.addTransaction(transaction)
    }

    fun getTransactionById(id: Int): Transaction? {
        return transactionsDao.getTransactionById(id)
    }

    fun getTransactionsByUserId(userId: Int): List<Transaction> {
        return transactionsDao.getTransactionsByUserId(userId)
    }
}