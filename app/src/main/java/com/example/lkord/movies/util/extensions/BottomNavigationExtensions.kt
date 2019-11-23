package com.example.lkord.movies.util.extensions

import com.google.android.material.bottomnavigation.BottomNavigationView

inline fun BottomNavigationView.onItemTapped(crossinline onNavigationItemTapped: (Int) -> Unit) {
    setOnNavigationItemSelectedListener {
        onNavigationItemTapped(it.itemId)
        true
    }
}