package org.harundemir.gamestore.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.harundemir.gamestore.R
import org.harundemir.gamestore.models.Order
import org.harundemir.gamestore.utils.Utils

class OrdersAdapter() :
    RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder>() {
    private var orders = emptyList<Order>()

    inner class OrdersViewHolder(itemView: View) : ViewHolder(itemView) {
        fun bind(order: Order) {
            val orderCode = itemView.findViewById<TextView>(R.id.orderCode)
            val orderDate = itemView.findViewById<TextView>(R.id.orderDate)

            orderCode.text = order.code
            orderDate.text = Utils.getFormattedDateTime(order.date)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.orders_list_item, parent, false)
        return OrdersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {
        val order = orders[position]
        holder.bind(order)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(items: List<Order>) {
        this.orders = items
        notifyDataSetChanged()
    }
}