package com.example.lkord.movies.ui.moviedetails

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.lkord.movies.R
import com.example.lkord.movies.detailsPresenter
import com.example.lkord.movies.model.data.Movie
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {

    private val detailsPresenter by lazy { detailsPresenter() }

    companion object {
        private const val DETAILS_KEY = "details"

        fun getLaunchIntent(from: Context, movieTitle: String?): Intent {
            val intent = Intent(from, MovieDetailsActivity::class.java)
            intent.putExtra(DETAILS_KEY, movieTitle)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val title = intent.getStringExtra(DETAILS_KEY)
        detailsPresenter.searchMovieWithDetails(title) {
            updateUI(it)
        }
    }

    private fun updateUI(movie: Movie) {
        Glide.with(this@MovieDetailsActivity).load(Uri.parse(movie.poster)).into(detailsBanner)
        detailsTitle.text = movie.title
        detailsYear.text = movie.year
        rating.rating = movie.imdbRating.toFloat() * 0.5F
        ratingText.text = movie.imdbRating
        director.text = movie.director
        runtime.text = movie.runtime
        plot.text = movie.plot
        stars.text = movie.actors
        genre.text = movie.genre
    }
}
