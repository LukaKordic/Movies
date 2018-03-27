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
import com.example.lkord.movies.api.MovieApiService
import com.example.lkord.movies.common.DETAILS_KEY
import com.example.lkord.movies.common.onClick
import com.example.lkord.movies.model.data.Movie
import kotlinx.android.synthetic.main.activity_movie_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailsActivity : AppCompatActivity(), Callback<Movie> {

    private val retrofit = App.retrofitInstance
    private val omdbService = retrofit.create(MovieApiService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val title = intent.getStringExtra(DETAILS_KEY)
        searchMovies(title)
    }

    //todo presenter
    private fun searchMovies(searchQuery: String) {
        omdbService.detailedSearchByTitle(searchQuery).enqueue(this)
    }

    override fun onFailure(call: Call<Movie>?, t: Throwable?) {
        t?.printStackTrace()
        Toast.makeText(this, getString(R.string.search_failed), Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<Movie>?, response: Response<Movie>?) {
        response?.body()?.run { updateUI(this) }
    }

    private fun updateUI(movie: Movie) {
        Glide.with(this@MovieDetailsActivity).load(Uri.parse(poster)).into(detailsBanner)
        detailsTitle.text = title
        detailsYear.text = movie.year
        rating.rating = imdbRating.toFloat() * 0.5F
        ratingText.text = imdbRating
        director.text = director
        runtime.text = runtime
        plot.text = plot
        stars.text = actors
        genre.text = genre


        genre.onClick { }
    }

    companion object {
        private const val DETAILS_KEY = "details"
        const val REQUEST_CODE_DETAILS = 5

        fun getLaunchIntent(from: Context, movieTitle: String?): Intent {
            val intent = Intent(from, MovieDetailsActivity::class.java)
            intent.putExtra(DETAILS_KEY, movieTitle)
            return intent
        }
    }
}
