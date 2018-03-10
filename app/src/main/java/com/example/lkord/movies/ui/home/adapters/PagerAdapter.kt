package com.example.lkord.movies.ui.home.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.lkord.movies.common.NUMBER_OF_FRAGMENTS
import com.example.lkord.movies.ui.favourites.FavouritesFragment
import com.example.lkord.movies.ui.home.HomeFragment
import com.example.lkord.movies.ui.search.SearchFragment

class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val fragmentList = listOf(HomeFragment(), FavouritesFragment(), SearchFragment())

    override fun getItem(position: Int): Fragment {

        return fragmentList[position]
    }

    override fun getCount(): Int {
        return NUMBER_OF_FRAGMENTS
    }
}