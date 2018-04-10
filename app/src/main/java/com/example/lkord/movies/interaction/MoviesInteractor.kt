package com.example.lkord.movies.interaction

import android.widget.Toast
import com.example.lkord.movies.App
import com.example.lkord.movies.R
import com.example.lkord.movies.api.MovieApiService
import com.example.lkord.movies.model.data.Movie
import com.example.lkord.movies.model.network.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MoviesInteractor @Inject constructor(private val moviesApi: MovieApiService) : MoviesInteractorInterface {
    override fun getMovies(searchQuery: String?, onResult: (List<Movie>?) -> Unit) {
        moviesApi.searchMoviesByTitle(title = searchQuery
                ?: "").enqueue(object : Callback<SearchResponse> {
            override fun onFailure(call: Call<SearchResponse>?, t: Throwable?) {
                t?.printStackTrace()
                Toast.makeText(App.instance, R.string.search_failed, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<SearchResponse>?, response: Response<SearchResponse>?) {
                response?.body()?.run { onResult(this.movies) }
            }

        })
    }

}

