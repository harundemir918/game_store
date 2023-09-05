package org.harundemir.gamestore.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.imageview.ShapeableImageView
import org.harundemir.gamestore.R
import org.harundemir.gamestore.activities.DetailActivity
import org.harundemir.gamestore.models.Game

class TopGamesAdapter(private val topGames: List<Game>) :
    RecyclerView.Adapter<TopGamesAdapter.GameViewHolder>() {
    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(game: Game) {
            val topGamesCover = itemView.findViewById<ShapeableImageView>(R.id.gameCover)
            val topGamesAvatar =
                itemView.findViewById<ShapeableImageView>(R.id.gameAvatar)
            val topGamesTitle = itemView.findViewById<TextView>(R.id.gameTitle)
            val topGamesCategory = itemView.findViewById<TextView>(R.id.gameCategory)
            val topGamesBuyButton = itemView.findViewById<MaterialButton>(R.id.gameBuyButton)

            topGamesCover.setImageResource(game.cover)
            topGamesAvatar.setImageResource(game.avatar)
            topGamesTitle.text = game.title
            topGamesCategory.text = game.category.title
            topGamesBuyButton.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra("game", game)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.game_list_item, parent, false)
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