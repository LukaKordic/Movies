package com.example.lkord.movies.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.lkord.movies.R
import com.example.lkord.movies.ui.favourites.FavouritesFragment
import com.example.lkord.movies.ui.home.HomeFragment
import com.example.lkord.movies.ui.search.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment.newInstance()
    private val favouritesFragment = FavouritesFragment.newInstance()
    private val searchFragment = SearchFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.navigation_home -> {
                transaction.replace(R.id.container, homeFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favourites -> {
                transaction.replace(R.id.container, favouritesFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_search -> {
                transaction.replace(R.id.container, searchFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

}
