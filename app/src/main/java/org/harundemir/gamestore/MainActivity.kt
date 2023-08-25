package org.harundemir.gamestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import org.harundemir.gamestore.databinding.ActivityMainBinding
import org.harundemir.gamestore.fragments.CategoriesFragment
import org.harundemir.gamestore.fragments.HomeFragment
import org.harundemir.gamestore.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //    private lateinit var themeSwitch: SwitchCompat
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
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_main, menu)
//
//        val menuItem = menu?.findItem(R.id.menu_theme_switch)
//        themeSwitch = menuItem?.actionView?.findViewById(R.id.themeSwitch) as SwitchCompat
//
//        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                // Enable Dark Mode
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//            } else {
//                // Enable Light Mode
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//            }
//            themeSwitch.isChecked = isChecked
//        }
//
//        return super.onCreateOptionsMenu(menu)
//    }
}