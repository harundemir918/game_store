package org.harundemir.gamestore.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.harundemir.gamestore.db.GameStoreDatabase
import org.harundemir.gamestore.models.CartItem
import org.harundemir.gamestore.models.Transaction
import org.harundemir.gamestore.models.TransactionItem
import org.harundemir.gamestore.repositories.TransactionItemsRepository
import org.harundemir.gamestore.repositories.TransactionsRepository
import org.harundemir.gamestore.utils.Utils
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {
    private val transactionsRepository: TransactionsRepository
    private val transactionItemsRepository: TransactionItemsRepository
    private var _transactionItems: MutableLiveData<List<Transaction>> = MutableLiveData()
    var transactionItems: LiveData<List<Transaction>> = _transactionItems

    init {
        val transactionsDao = GameStoreDatabase.getDatabase(application).transactionsDao()
        val transactionItemsDao = GameStoreDatabase.getDatabase(application).transactionItemsDao()
        transactionsRepository = TransactionsRepository(transactionsDao)
        transactionItemsRepository = TransactionItemsRepository(transactionItemsDao)
        transactionsRepository.getAllTransactions.observeForever { newTransactionItems ->
            _transactionItems.value = newTransactionItems
        }
    }

    fun addTransaction(cartItems: List<CartItem>) {
        viewModelScope.launch(Dispatchers.IO) {
            val transactionCode = Utils.generateTransactionCode()
            val date = java.time.Instant.now().toString()
            val transaction = Transaction(
                userId = 1,
                code = transactionCode,
                date = date,
                total = 0.0
            )
            addOrUpdateTransaction(transaction)
            val getTransaction =
                getTransactionByUserIdAndCode(userId = transaction.userId, code = transaction.code)
            if (getTransaction != null) {
                addTransactionItem(transaction = getTransaction, cartItems = cartItems)
            }
        }
    }

    private fun addTransactionItem(transaction: Transaction, cartItems: List<CartItem>) {
        viewModelScope.launch(Dispatchers.IO) {
            val total = cartItems.sumOf { it.total }
            for (item in cartItems) {
                val transactionItem = TransactionItem(
                    transactionId = transaction.id!!,
                    item = item,
                    total = item.total,
                    date = transaction.date,
                )
                transactionItemsRepository.addTransactionItem(transactionItem)
            }
            val updatedTransaction = transaction.copy(total = total)
            addOrUpdateTransaction(updatedTransaction)
        }
    }

    private suspend fun addOrUpdateTransaction(transaction: Transaction) {
        transactionsRepository.addTransaction(transaction)
    }

    fun getTransactionById(id: Int): Transaction? {
        return transactionsRepository.getTransactionById(id)
    }

    fun getTransactionsByUserId(userId: Int): List<Transaction> {
        return transactionsRepository.getTransactionsByUserId(userId)
    }

    fun getTransactionByUserIdAndCode(userId: Int, code: String): Transaction? {
        return transactionsRepository.getTransactionByUserIdAndCode(userId, code)
    }
}