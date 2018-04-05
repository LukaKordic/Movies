package com.example.lkord.movies.interaction

import android.widget.Toast
import com.example.lkord.movies.App
import com.example.lkord.movies.R
import com.example.lkord.movies.api.MovieApiService
import com.example.lkord.movies.model.data.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DetailsInteractor @Inject constructor(private val moviesApi: MovieApiService) : DetailsInteractorInterface {

    override fun getMovieWithDetails(searchQuery: String?, onResult: (Movie) -> Unit) {
        moviesApi.detailedSearchByTitle(title = searchQuery ?: "").enqueue(object : Callback<Movie> {
            override fun onFailure(call: Call<Movie>?, t: Throwable?) {
                t?.printStackTrace()
                Toast.makeText(App.instance, R.string.search_failed, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Movie>?, response: Response<Movie>?) {
               response?.body()?.run { onResult(this) }
            }

        })
    }
}