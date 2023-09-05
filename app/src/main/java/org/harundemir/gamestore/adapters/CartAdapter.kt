package org.harundemir.gamestore.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.harundemir.gamestore.R
import org.harundemir.gamestore.models.CartItem

class CartAdapter(
    private val onDeleteClicked: (CartItem) -> Unit,
    private val onAddClicked: (CartItem) -> Unit,
    private val onSubtractClicked: (CartItem) -> Unit
) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    private var items = emptyList<CartItem>()

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(cartItem: CartItem) {
            val cartItemImage = itemView.findViewById<ImageView>(R.id.cartItemImage)
            val cartItemTitle = itemView.findViewById<TextView>(R.id.cartItemTitle)
            val cartItemPrice = itemView.findViewById<TextView>(R.id.cartItemPrice)
            val cartItemAddButton = itemView.findViewById<ImageButton>(R.id.cartItemAddButton)
            val cartItemSubtractButton =
                itemView.findViewById<ImageButton>(R.id.cartItemSubtractButton)
            val cartItemPiece = itemView.findViewById<TextView>(R.id.cartItemPiece)
            val cartItemDeleteButton = itemView.findViewById<ImageButton>(R.id.cartItemDeleteButton)

            val game = cartItem.item
            cartItemImage.setImageResource(game.avatar)
            cartItemTitle.text = game.title
            cartItemPrice.text =
                itemView.context.getString(R.string.total_with_value, game.price.toString())
            cartItemPiece.text = cartItem.quantity.toString()

            cartItemDeleteButton.setOnClickListener {
                onDeleteClicked.invoke(cartItem)
            }

            cartItemAddButton.setOnClickListener {
                onAddClicked.invoke(cartItem)
            }

            cartItemSubtractButton.setOnClickListener {
                onSubtractClicked.invoke(cartItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(items: List<CartItem>) {
        this.items = items
        notifyDataSetChanged()
    }
}