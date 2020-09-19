package com.example.lkord.movies.ui.moviedetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.model.Movie
import com.example.lkord.movies.R
import com.example.lkord.movies.util.MOVIE_KEY
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_movie_details.*

fun startMovieDetailsActivity(from: Context, movie: Movie) = from.startActivity(
  Intent(from, MovieDetailsActivity::class.java).putExtra(MOVIE_KEY, movie))

@AndroidEntryPoint
class MovieDetailsActivity : AppCompatActivity() {
  
  private val movie by lazy { intent.extras?.getSerializable(MOVIE_KEY) as Movie }
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_movie_details)
    overview.text = movie.overview
  }
}