package com.example.lkord.movies.ui

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.lkord.movies.R
import com.example.lkord.movies.common.SEARCH_QUERY_KEY
import com.example.lkord.movies.ui.favourites.FavouritesFragment
import com.example.lkord.movies.ui.home.HomeFragment
import com.example.lkord.movies.ui.search.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager
    private val transaction = fragmentManager.beginTransaction()
    private val homeFragment = HomeFragment.newInstance()
    private val favouritesFragment = FavouritesFragment.newInstance()
    private val searchFragment = SearchFragment.newInstance(getSearchQuery())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transaction.replace(R.id.container, homeFragment).commit()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun getSearchQuery(): String {
        val searchIntent = intent
        if (searchIntent.action == Intent.ACTION_SEARCH) {
            return searchIntent.getStringExtra(SearchManager.QUERY)
        }
        return ""
    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
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
