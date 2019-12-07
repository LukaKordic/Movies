package com.example.data.networking.service

import com.example.data.networking.model.response.MovieResponseWrapper
import io.reactivex.Single

interface MovieApiService {

  fun getNowPlayingMovies(): Single<MovieResponseWrapper>

  fun getPopularMovies(): Single<MovieResponseWrapper>
}