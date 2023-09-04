package org.harundemir.gamestore.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.harundemir.gamestore.R
import org.harundemir.gamestore.models.OrderItem

class OrderDetailAdapter :
    RecyclerView.Adapter<OrderDetailAdapter.OrderDetailViewHolder>() {
    private var items = emptyList<OrderItem>()

    inner class OrderDetailViewHolder(itemView: View) : ViewHolder(itemView) {
        fun bind(orderItem: OrderItem) {
            val orderDetailImage = itemView.findViewById<ImageView>(R.id.orderDetailItemImage)
            val orderDetailTitle = itemView.findViewById<TextView>(R.id.orderDetailItemTitle)
            val orderDetailPrice = itemView.findViewById<TextView>(R.id.orderDetailItemPrice)
            val orderDetailQuantity = itemView.findViewById<TextView>(R.id.orderDetailItemQuantity)

            orderDetailImage.setImageResource(orderItem.item.item.cover)
            orderDetailTitle.text = orderItem.item.item.title
            orderDetailPrice.text = orderItem.item.item.price.toString()
            orderDetailQuantity.text = itemView.context.getString(
                R.string.quantity_with_value,
                orderItem.item.quantity.toString()
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderDetailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_detail_list_item, parent, false)
        return OrderDetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: OrderDetailViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(items: List<OrderItem>) {
        this.items = items
        notifyDataSetChanged()
    }
}