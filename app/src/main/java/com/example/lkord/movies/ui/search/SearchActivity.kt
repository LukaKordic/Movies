package com.example.lkord.movies.ui.search

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lkord.movies.R

class SearchActivity : AppCompatActivity() {

    private lateinit var searchQuery: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        getSearchQuery(intent)
        println(searchQuery)
    }

    private fun getSearchQuery(searchIntent: Intent) {
        if (searchIntent.action == Intent.ACTION_SEARCH) {
            searchQuery = searchIntent.getStringExtra(SearchManager.QUERY)
        }
    }
}
