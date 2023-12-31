package org.harundemir.gamestore.activities

import android.content.Intent
import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import org.harundemir.gamestore.R
import org.harundemir.gamestore.adapters.DetailSliderAdapter
import org.harundemir.gamestore.databinding.ActivityDetailBinding
import org.harundemir.gamestore.models.Game
import org.harundemir.gamestore.viewmodels.CartViewModel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var cartViewModel: CartViewModel
    private var isDescriptionExpanded = false

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
        binding.detailBuy.text = getString(R.string.detail_buy, game.price.toString())

        val fullDescription = game.description
        val truncatedDescription = getTruncatedText(fullDescription)
        binding.detailDescription.text = truncatedDescription

        binding.detailDescReadMore.setOnClickListener {
            isDescriptionExpanded = !isDescriptionExpanded
            if (isDescriptionExpanded) {
                binding.detailDescription.text = fullDescription
                binding.detailDescription.maxLines = Int.MAX_VALUE
                binding.detailDescReadMore.text = getString(R.string.read_less)
            } else {
                binding.detailDescription.text = truncatedDescription
                binding.detailDescription.maxLines = 3
                binding.detailDescReadMore.text = getString(R.string.read_more)
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            binding.detailDescription.justificationMode = JUSTIFICATION_MODE_INTER_WORD
        }

        cartViewModel = ViewModelProvider(this)[CartViewModel::class.java]
        binding.detailBuy.setOnClickListener {
            addGameToCart(game)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun getTruncatedText(text: String): String {
        val maxLength = 250
        return if (text.length > maxLength) {
            "${text.substring(0, maxLength)}..."
        } else {
            text
        }
    }

    private fun addGameToCart(game: Game) {
        cartViewModel.addItemToCart(
            game
        )
        val snackbar = Snackbar.make(
            binding.root,
            getString(R.string.game_added_to_cart),
            Snackbar.LENGTH_SHORT
        )
        snackbar.setAction(getString(R.string.view_cart)) {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
        snackbar.show()
    }
}