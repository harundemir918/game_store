package org.harundemir.gamestore.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import org.harundemir.gamestore.R
import org.harundemir.gamestore.activities.CategoryDetailActivity
import org.harundemir.gamestore.models.Category

class CategoriesAdapter(private var categories: List<Category>) :
    RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {
    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(category: Category) {
            val categoryItem = itemView.findViewById<ConstraintLayout>(R.id.categoryItem)
            val categoryImage = itemView.findViewById<ImageView>(R.id.category_item_image)
            val categoryTitle = itemView.findViewById<TextView>(R.id.category_item_title)

            categoryImage.setImageResource(category.cover)
            categoryTitle.text = category.title

            categoryItem.setOnClickListener {
                val intent = Intent(itemView.context, CategoryDetailActivity::class.java)
                intent.putExtra("category", category)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_list_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setFilteredList(categories: List<Category>) {
        this.categories = categories
        notifyDataSetChanged()
    }
}