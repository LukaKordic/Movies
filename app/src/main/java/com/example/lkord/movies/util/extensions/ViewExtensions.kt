package com.example.lkord.movies.util.extensions

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.lkord.movies.util.IMAGE_BASE_URL

inline fun View.onClick(crossinline onClick: () -> Unit) {
  setOnClickListener { onClick() }
}

fun ImageView.loadImage(poster: String) {
  Glide.with(this)
      .load(IMAGE_BASE_URL + poster)
      .into(this)
}

var View.isVisible: Boolean
  set(value) {
    if (value) {
      visibility = View.VISIBLE
    } else {
      visibility = View.GONE
    }
  }
  get() = visibility == View.VISIBLE