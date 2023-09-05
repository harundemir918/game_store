package org.harundemir.gamestore.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.harundemir.gamestore.R
import org.harundemir.gamestore.activities.DetailActivity
import org.harundemir.gamestore.models.Category
import org.harundemir.gamestore.models.Game

class CategoryDetailAdapter(private var items: List<Game>): RecyclerView.Adapter<CategoryDetailAdapter.CategoryDetailViewHolder>() {
    inner class CategoryDetailViewHolder(itemView: View) : ViewHolder(itemView) {
        fun bind(game: Game) {
            val gameCover = itemView.findViewById<ImageView>(R.id.gameCover)
            val gameAvatar = itemView.findViewById<ImageView>(R.id.gameAvatar)
            val gameTitle = itemView.findViewById<TextView>(R.id.gameTitle)
            val gameCategory = itemView.findViewById<TextView>(R.id.gameCategory)
            val gameBuyButton = itemView.findViewById<Button>(R.id.gameBuyButton)

            gameCover.setImageResource(game.cover)
            gameAvatar.setImageResource(game.avatar)
            gameTitle.text = game.title
            gameCategory.text = game.category.title

            gameBuyButton.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra("game", game)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.game_list_item, parent, false)
        return CategoryDetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CategoryDetailViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setFilteredList(categories: List<Game>) {
        this.items = categories
        notifyDataSetChanged()
    }
}