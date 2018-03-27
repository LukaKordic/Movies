package com.example.lkord.movies.ui.listener

import android.support.design.widget.BottomNavigationView
import android.view.MenuItem

class SimpleNavigationListener(private val onNavigationItemTapped: (Int) -> Unit) : BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        onNavigationItemTapped(item.itemId)
    }
}

inline fun BottomNavigationView.onItemTapped(crossinline onNavigationItemTapped: (Int) -> Unit) {
    setOnNavigationItemSelectedListener {
        onNavigationItemTapped(it.itemId)
        false
    }
}