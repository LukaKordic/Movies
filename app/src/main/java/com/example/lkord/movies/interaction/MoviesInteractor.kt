package com.example.lkord.movies.interaction

import com.example.lkord.movies.api.MovieApiService
import com.example.lkord.movies.model.data.Movie
import com.example.lkord.movies.model.network.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MoviesInteractor @Inject constructor(private val moviesApi: MovieApiService) : MoviesInteractorInterface {

    override fun getMovies(page: Int, searchQuery: String?, onResult: (List<Movie>) -> Unit) {
        moviesApi.searchMoviesByTitle(searchQuery ?: "").enqueue(object : Callback<SearchResponse> {
            override fun onFailure(call: Call<SearchResponse>?, t: Throwable?) {
                //todo neki klinac
            }

            override fun onResponse(call: Call<SearchResponse>?, response: Response<SearchResponse>?) {
                response?.body()?.run { onResult(movies) }
            }
        })
    }
}

