package com.example.lkord.movies.ui.search.view

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.example.lkord.movies.R
import com.example.lkord.movies.searchPresenter
import com.example.lkord.movies.ui.search.adapters.SearchRecyclerAdapter
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    private lateinit var recAdapter: SearchRecyclerAdapter

    private lateinit var searchQuery: String

    private val searchPresenter by lazy { searchPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        if (intent.action == Intent.ACTION_SEARCH) {
            searchQuery = intent.getStringExtra(SearchManager.QUERY)
            searchPresenter.loadMovies(searchQuery) {
                recAdapter.addMovies(it)
                initUI()
            }
        }
    }

    private fun initUI() {
        with(searchResults) {
            adapter = recAdapter
            layoutManager = LinearLayoutManager(this@SearchActivity)
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
        }
    }
}
