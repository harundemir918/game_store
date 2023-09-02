package org.harundemir.gamestore.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.harundemir.gamestore.R
import org.harundemir.gamestore.models.Transaction
import org.harundemir.gamestore.utils.Utils

class TransactionsAdapter() :
    RecyclerView.Adapter<TransactionsAdapter.TransactionsViewHolder>() {
    private var transactions = emptyList<Transaction>()

    inner class TransactionsViewHolder(itemView: View) : ViewHolder(itemView) {
        fun bind(transaction: Transaction) {
            val transactionCode = itemView.findViewById<TextView>(R.id.transactionCode)
            val transactionDate = itemView.findViewById<TextView>(R.id.transactionDate)

            transactionCode.text = transaction.code
            transactionDate.text = Utils.getFormattedDateTime(transaction.date)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.transactions_list_item, parent, false)
        return TransactionsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return transactions.size
    }

    override fun onBindViewHolder(holder: TransactionsViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.bind(transaction)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(items: List<Transaction>) {
        this.transactions = items
        notifyDataSetChanged()
    }
}