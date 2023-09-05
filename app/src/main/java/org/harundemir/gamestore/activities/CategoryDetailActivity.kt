package org.harundemir.gamestore.activities

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import org.harundemir.gamestore.adapters.CategoryDetailAdapter
import org.harundemir.gamestore.data.categoryList
import org.harundemir.gamestore.data.gameList
import org.harundemir.gamestore.databinding.ActivityCategoryDetailBinding
import org.harundemir.gamestore.models.Category
import org.harundemir.gamestore.models.Game
import java.util.Locale

class CategoryDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryDetailBinding
    private lateinit var categoryDetailAdapter: CategoryDetailAdapter
    private lateinit var categoryGameList: List<Game>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.categoryDetailToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        val category = intent.getSerializableExtra("category") as? Category
        binding.categoryDetailToolbarTitle.text = category?.title

        categoryGameList = gameList.filter { it.category.id == category?.id }
        categoryDetailAdapter = CategoryDetailAdapter(categoryGameList)
        binding.categoryDetailList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.categoryDetailList.adapter = categoryDetailAdapter
        if (gameList.isEmpty()) {
            binding.categoryDetailNotFound.isVisible = true
            binding.categoryDetailList.isVisible = false
        } else {
            binding.categoryDetailSearch.apply {
                setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        return false
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        filterList(newText)
                        return true
                    }
                })
            }
        }
    }

    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = ArrayList<Game>()
            for (game in categoryGameList) {
                if (game.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(game)
                }
            }

            if (filteredList.isNotEmpty()) {
                binding.categoryDetailList.isVisible = true
                binding.categoryDetailNotFound.isVisible = false
                categoryDetailAdapter.setFilteredList(filteredList)
            } else {
                binding.categoryDetailList.isVisible = false
                binding.categoryDetailNotFound.isVisible = true
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}