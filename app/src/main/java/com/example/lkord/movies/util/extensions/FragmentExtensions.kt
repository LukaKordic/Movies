package com.example.lkord.movies.util.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun FragmentManager.replace(container: Int, fragment: Fragment) {
  this.beginTransaction().replace(container, fragment).commit()
}