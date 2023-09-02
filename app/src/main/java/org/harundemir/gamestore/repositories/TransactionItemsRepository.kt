package org.harundemir.gamestore.repositories

import androidx.lifecycle.LiveData
import org.harundemir.gamestore.db.dao.TransactionItemsDao
import org.harundemir.gamestore.models.TransactionItem

class TransactionItemsRepository(private val transactionItemsDao: TransactionItemsDao) {
    val getAllTransactionItems: LiveData<List<TransactionItem>> =
        transactionItemsDao.getAllTransactionItems()

    suspend fun addTransactionItem(transactionItem: TransactionItem) {
        transactionItemsDao.addTransactionItem(transactionItem)
    }

    fun getTransactionItemById(id: Int): TransactionItem? {
        return transactionItemsDao.getTransactionItemById(id)
    }
}