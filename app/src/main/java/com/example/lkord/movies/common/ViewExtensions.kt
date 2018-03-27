package com.example.lkord.movies.common

import android.net.Uri
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import com.bumptech.glide.Glide

inline fun View.onClick(crossinline onClick: () -> Unit) {
    setOnClickListener { onClick() }
}

inline fun CheckBox.onCheckChanged(crossinline onClick: (Boolean) -> Unit){
    setOnCheckedChangeListener { buttonView, isChecked -> onClick(isChecked) }
}

fun View.loadImage(view: View, poster: String, imageView: ImageView) {
    Glide.with(view).load(Uri.parse(poster)).into(imageView)
}