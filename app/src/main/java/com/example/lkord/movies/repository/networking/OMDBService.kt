package com.example.lkord.movies.repository.networking

import com.example.lkord.movies.common.OMDB_API_KEY
import com.example.lkord.movies.repository.dataobjects.Movie
import com.example.lkord.movies.repository.dataobjects.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface OMDBService {

    @GET("?apikey=$OMDB_API_KEY")
    fun searchMoviesByTitle(@Query("s") title: String): Call<SearchResponse>

    @GET("?apikey=$OMDB_API_KEY")
    fun detailedSearchByTitle(@Query("t") title: String): Call<Movie>

    @GET("?apikey=$OMDB_API_KEY")
    fun getTopMovies(): Call<List<Movie>>
}