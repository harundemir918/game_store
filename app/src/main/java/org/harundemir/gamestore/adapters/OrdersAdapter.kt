package org.harundemir.gamestore.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.harundemir.gamestore.R
import org.harundemir.gamestore.activities.OrderDetailActivity
import org.harundemir.gamestore.models.Order
import org.harundemir.gamestore.utils.Utils

class OrdersAdapter() : RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder>() {
    private var orders = emptyList<Order>()

    inner class OrdersViewHolder(itemView: View) : ViewHolder(itemView) {
        fun bind(order: Order) {
            val orderCard = itemView.findViewById<CardView>(R.id.orderCard)
            val orderCode = itemView.findViewById<TextView>(R.id.orderCode)
            val orderTotal = itemView.findViewById<TextView>(R.id.orderTotal)
            val orderDate = itemView.findViewById<TextView>(R.id.orderDate)

            orderCode.text = order.code
            orderTotal.text =
                itemView.context.getString(R.string.total_with_value, order.total.toString())
            orderDate.text = Utils.getFormattedDateTime(order.date)

            orderCard.setOnClickListener {
                val intent = Intent(itemView.context, OrderDetailActivity::class.java)
                intent.putExtra("order", order)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.orders_list_item, parent, false)
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