package com.example.lkord.movies.ui.search

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.lkord.movies.App
import com.example.lkord.movies.R
import com.example.lkord.movies.dataobjects.SearchResponse
import com.example.lkord.movies.networking.OMDBService
import com.example.lkord.movies.ui.moviedetails.MovieDetailsActivity
import com.example.lkord.movies.ui.search.adapters.SearchRecyclerAdapter
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.Call
import retrofit2.Callback

class SearchActivity : AppCompatActivity(), Callback<SearchResponse> {

    private val retrofit = App.retrofitInstance
    private val omdbService = retrofit.create(OMDBService::class.java)
    private lateinit var recAdapter: SearchRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        doSearch(intent)
    }

    private fun doSearch(searchIntent: Intent) {
        if (searchIntent.action == Intent.ACTION_SEARCH) {
            val searchQuery = searchIntent.getStringExtra(SearchManager.QUERY)
            omdbService.searchMoviesByTitle(searchQuery).enqueue(this)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        intent?.let { doSearch(intent) }
    }

    override fun onFailure(call: Call<SearchResponse>?, t: Throwable?) {
        t?.printStackTrace()
        Toast.makeText(this, getString(R.string.search_failed), Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<SearchResponse>?, searchResponse: retrofit2.Response<SearchResponse>) {
        searchResponse.body()?.let {
            recAdapter = SearchRecyclerAdapter(it.movies) {
                startActivity(MovieDetailsActivity.getLaunchIntent(this, it.title))
            }
        }
        initializeUI(recAdapter)
    }

    private fun initializeUI(recAdapter: SearchRecyclerAdapter) {
        with(searchResults) {
            adapter = recAdapter
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
        }
    }
}
