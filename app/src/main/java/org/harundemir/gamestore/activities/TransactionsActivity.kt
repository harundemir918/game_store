package org.harundemir.gamestore.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.harundemir.gamestore.adapters.TransactionsAdapter
import org.harundemir.gamestore.databinding.ActivityTransactionsBinding
import org.harundemir.gamestore.viewmodels.TransactionsViewModel

class TransactionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransactionsBinding
    private lateinit var transactionsViewModel: TransactionsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        transactionsViewModel = ViewModelProvider(this)[TransactionsViewModel::class.java]

        val transactionsAdapter = TransactionsAdapter(transactionsViewModel.transactionItems)
        binding.transactionsList.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )
        binding.transactionsList.adapter = transactionsAdapter
    }
}