package com.example.lkord.movies.ui.moviedetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.lkord.movies.App
import com.example.lkord.movies.R
import com.example.lkord.movies.common.base.BaseActivity
import com.example.lkord.movies.data.db.entities.Movie
import com.example.lkord.movies.util.IMAGE_BASE_URL_ORIGINAL
import com.example.lkord.movies.util.MOVIE_KEY
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.toolbar.*

class MovieDetailsActivity : BaseActivity() {

  private val movie by lazy { intent.extras?.getSerializable(MOVIE_KEY) as Movie }

  companion object {
    fun launch(from: Context, movie: Movie) = from.startActivity(Intent(from, MovieDetailsActivity::class.java).putExtra(MOVIE_KEY, movie))
  }

  override fun injectDependencies() = App.component.inject(this)

  override fun getLayout() = R.layout.activity_movie_details

  override fun viewReady() {

  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_movie_details)
    initUI()
  }

  private fun initUI() {
    initToolbar()
    Glide.with(this)
        .asBitmap()
        .load(IMAGE_BASE_URL_ORIGINAL + movie.posterPath)
        .into(moviePoster)
    overview.text = movie.overview
  }

  private fun initToolbar() {
    setSupportActionBar(toolbar)
    supportActionBar?.setHomeAsUpIndicator(R.drawable.back_arrow_white_24dp)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    toolbarTitle.text = movie.title
    searchIcon.visibility = View.GONE
  }
}
