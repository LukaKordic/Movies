package com.example.lkord.movies.common.extensions

import android.support.design.widget.BottomNavigationView

inline fun BottomNavigationView.onItemTapped(crossinline onNavigationItemTapped: (Int) -> Unit) {
    setOnNavigationItemSelectedListener {
        onNavigationItemTapped(it.itemId)
        true
    }
}