package org.harundemir.gamestore.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import org.harundemir.gamestore.adapters.TransactionsAdapter
import org.harundemir.gamestore.databinding.ActivityTransactionsBinding
import org.harundemir.gamestore.viewmodels.TransactionsViewModel

class TransactionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransactionsBinding
    private val transactionsViewModel: TransactionsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.transactionsToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        val transactionsAdapter = TransactionsAdapter()
        binding.transactionsList.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )
        binding.transactionsList.adapter = transactionsAdapter
        transactionsViewModel.transactionItems.observe(this) { items ->
            if (items.isEmpty()) {
                transactionsAdapter.setData(emptyList())
                binding.transactionsNoItemsFound.isVisible = true
            } else {
                transactionsAdapter.setData(items)
                binding.transactionsNoItemsFound.isVisible = false
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}