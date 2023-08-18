package org.harundemir.gamestore.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.harundemir.gamestore.R
import org.harundemir.gamestore.adapters.DetailSliderAdapter
import org.harundemir.gamestore.databinding.ActivityDetailBinding
import org.harundemir.gamestore.models.Game

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.detailToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        val game = intent.getSerializableExtra("game") as? Game

        val images = game!!.images
        binding.detailSlider.apply {
            clipChildren = false
            clipToPadding = false
            offscreenPageLimit = 2
        }
        binding.detailSlider.adapter = DetailSliderAdapter(this, images)
        binding.detailSliderIndicator.setViewPager(binding.detailSlider)

        binding.detailTitle.text = game.title
        binding.detailCategory.text = game.category.title
        binding.detailRateInfo.text = game.rate.toString()
        binding.detailSizeInfo.text = getString(R.string.rate_with_unit, game.size.toString())
        binding.detailCategoryInfo.text = game.category.title
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}