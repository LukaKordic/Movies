package com.example.lkord.movies.ui.moviedetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lkord.movies.R

class MovieDetailsActivity : AppCompatActivity() {

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
        searchMovies(title)
    }

    //todo presenter
    private fun searchMovies(searchQuery: String) {
    }

//    private fun updateUI(movie: Movie) {
//        Glide.with(this@MovieDetailsActivity).load(Uri.parse(poster)).into(detailsBanner)
//        detailsTitle.text = title
//        detailsYear.text = movie.year
//        rating.rating = imdbRating.toFloat() * 0.5F
//        ratingText.text = imdbRating
//        director.text = director
//        runtime.text = runtime
//        plot.text = plot
//        stars.text = actors
//        genre.text = genre
//    }
}
