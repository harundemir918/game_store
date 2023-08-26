package org.harundemir.gamestore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.harundemir.gamestore.R
import org.harundemir.gamestore.models.Cart

class CartAdapter :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    private var items = emptyList<Cart>()

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(cartItem: Cart) {
            val cartItemImage = itemView.findViewById<ImageView>(R.id.cartItemImage)
            val cartItemTitle = itemView.findViewById<TextView>(R.id.cartItemTitle)
            val cartItemPrice = itemView.findViewById<TextView>(R.id.cartItemPrice)
            val cartItemAddButton = itemView.findViewById<ImageButton>(R.id.cartItemAddButton)
            val cartItemSubtractButton =
                itemView.findViewById<ImageButton>(R.id.cartItemSubtractButton)
            val cartItemPiece = itemView.findViewById<TextView>(R.id.cartItemPiece)

            val game = cartItem.item
            cartItemImage.setImageResource(game.avatar)
            cartItemTitle.text = game.title
            cartItemPrice.text = "₺${game.price}"
            cartItemPiece.text = cartItem.piece.toString()
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

    fun setData(items: List<Cart>) {
        this.items = items
        notifyDataSetChanged()
    }
}