package com.example.lkord.movies.ui.search

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lkord.movies.R
import com.example.lkord.movies.common.SEARCH_QUERY_KEY
import com.example.lkord.movies.dataobjects.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment(), Callback<List<Movie>> {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.search_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onFailure(call: Call<List<Movie>>?, t: Throwable?) {
    }

    override fun onResponse(call: Call<List<Movie>>?, response: Response<List<Movie>>?) {

    }

    companion object {
        fun newInstance(searchQuery: String): SearchFragment {
            val fragment = SearchFragment()

            val bundle = Bundle()
            bundle.putString(SEARCH_QUERY_KEY, searchQuery)
            fragment.arguments = bundle

            return fragment
        }
    }
}