package org.harundemir.gamestore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import org.harundemir.gamestore.R
import org.harundemir.gamestore.models.Game

class TopGamesAdapter(private val topGames: List<Game>) :
    RecyclerView.Adapter<TopGamesAdapter.GameViewHolder>() {
    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(game: Game) {
            val topGamesCover = itemView.findViewById<ShapeableImageView>(R.id.top_games_item_cover)
            val topGamesAvatar =
                itemView.findViewById<ShapeableImageView>(R.id.top_games_item_avatar)
            val topGamesTitle = itemView.findViewById<TextView>(R.id.top_games_item_title)
            val topGamesCategory = itemView.findViewById<TextView>(R.id.top_games_item_category)

            topGamesCover.setImageResource(game.cover)
            topGamesAvatar.setImageResource(game.avatar)
            topGamesTitle.text = game.title
            topGamesCategory.text = game.category.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.top_games_list_item, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = topGames[position]
        holder.bind(game)
    }

    override fun getItemCount(): Int {
        return topGames.size
    }
}