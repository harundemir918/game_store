package org.harundemir.gamestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import org.harundemir.gamestore.databinding.ActivityMainBinding
import org.harundemir.gamestore.fragments.CategoriesFragment
import org.harundemir.gamestore.fragments.HomeFragment
import org.harundemir.gamestore.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val onNavigationItemSelectedListener =
        NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bnHome -> {
                    showFragment(HomeFragment())
                    return@OnItemSelectedListener true
                }

                R.id.bnCategories -> {
                    showFragment(CategoriesFragment())
                    return@OnItemSelectedListener true
                }

                R.id.bnProfile -> {
                    showFragment(ProfileFragment())
                    return@OnItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.bottomNavigationBar.setOnItemSelectedListener(onNavigationItemSelectedListener)
        setSupportActionBar(binding.toolbar)
        showFragment(HomeFragment())
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}