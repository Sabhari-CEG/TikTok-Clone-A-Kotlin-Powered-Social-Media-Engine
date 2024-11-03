package com.example.kotlin_training

import ImagePagerAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Set up ViewPager
        val pagerAdapter = ImagePagerAdapter()
        viewPager.adapter = pagerAdapter
        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
        // Start from middle to enable infinite scrolling
        viewPager.setCurrentItem(0, true)

        // Bottom navigation setup
        bottomNavigation.selectedItemId = R.id.navigation_home

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    true
                }
                R.id.navigation_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                else -> false
            }
        }
    }
}