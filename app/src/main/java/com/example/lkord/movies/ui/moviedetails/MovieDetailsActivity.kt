package com.example.lkord.movies.ui.moviedetails

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.lkord.movies.App
import com.example.lkord.movies.R
import com.example.lkord.movies.common.DETAILS_KEY
import com.example.lkord.movies.dataobjects.Movie
import com.example.lkord.movies.networking.OMDBService
import kotlinx.android.synthetic.main.activity_movie_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailsActivity : AppCompatActivity(), Callback<Movie> {

    private val retrofit = App.retrofitInstance
    private val omdbService = retrofit.create(OMDBService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val title = intent.getStringExtra(DETAILS_KEY)
        doSearch(title)
    }

    private fun doSearch(searchQuery: String) {
        omdbService.detailedSearchByTitle(searchQuery).enqueue(this)
    }

    override fun onFailure(call: Call<Movie>?, t: Throwable?) {
        t?.printStackTrace()
        Toast.makeText(this, getString(R.string.search_failed), Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<Movie>?, response: Response<Movie>?) {
        updateUI(response?.body())
    }

    private fun updateUI(movie: Movie?) {
        movie?.let {
            Glide.with(this).load(Uri.parse(it.poster)).into(detailsBanner)
            detailsTitle.text = it.title
            detailsYear.text = it.year
            rating.rating = it.imdbRating.toFloat() * 0.5F
            ratingText.text = it.imdbRating
            director.text = it.director
            runtime.text = it.runtime
            plot.text = it.plot
            stars.text = it.actors
            genre.text = it.genre
        }
    }

    companion object {
        fun getLaunchIntent(from: Context, movieTitle: String?): Intent {
            val intent = Intent(from, MovieDetailsActivity::class.java)
            intent.putExtra(DETAILS_KEY, movieTitle)
            return intent
        }
    }
}
