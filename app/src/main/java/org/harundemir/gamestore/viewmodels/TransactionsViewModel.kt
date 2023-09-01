package org.harundemir.gamestore.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.harundemir.gamestore.db.GameStoreDatabase
import org.harundemir.gamestore.models.Cart
import org.harundemir.gamestore.models.Transaction
import org.harundemir.gamestore.repositories.TransactionsRepository
import org.harundemir.gamestore.utils.Utils

class TransactionsViewModel(application: Application) : AndroidViewModel(application) {
    private val transactionsRepository: TransactionsRepository
    private var _transactionItems: List<Transaction> = emptyList()
    var transactionItems: List<Transaction> = _transactionItems

    init {
        val transactionsDao = GameStoreDatabase.getDatabase(application).transactionsDao()
        transactionsRepository = TransactionsRepository(transactionsDao)
        _transactionItems = transactionsRepository.getAllTransactions
    }

    fun addTransaction(cartItems: List<Cart>) {
        viewModelScope.launch(Dispatchers.IO) {
            for (item in cartItems) {
                val transaction = Transaction(
                    userId = 1,
                    code = Utils.generateTransactionCode(),
                    date = java.time.Instant.now().toString(),
                    items = item
                )
                transactionsRepository.addTransaction(transaction)
            }
        }
    }

    fun getTransactionById(id: Int): Transaction? {
        return transactionsRepository.getTransactionById(id)
    }

    fun getTransactionsByUserId(userId: Int): List<Transaction> {
        return transactionsRepository.getTransactionsByUserId(userId)
    }
}