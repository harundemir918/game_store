package org.harundemir.gamestore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.harundemir.gamestore.R
import org.harundemir.gamestore.models.Category

class CategoriesHorizontalAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoriesHorizontalAdapter.CategoryViewHolder>() {
    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(category: Category) {
            val categoryImage =
                itemView.findViewById<ImageView>(R.id.category_horizontal_item_image)
            val categoryTitle = itemView.findViewById<TextView>(R.id.category_horizontal_item_title)

            categoryImage.setImageResource(category.icon)
            categoryTitle.text = category.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_horizontal_list_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}