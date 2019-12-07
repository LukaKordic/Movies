package com.example.lkord.movies.di.modules

import com.example.data.networking.MovieAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL = "https://api.themoviedb.org/3/"

@Module
class NetworkingModule {

  @Singleton
  @Provides
  fun baseUrl(): String = BASE_URL

  @Singleton
  @Provides
  fun converterFactory(): GsonConverterFactory = GsonConverterFactory.create()

  @Singleton
  @Provides
  fun httpLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
      level = HttpLoggingInterceptor.Level.BODY
    }
  }

  @Singleton
  @Provides
  fun okhttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

  @Singleton
  @Provides
  fun retrofit(baseUrl: String, client: OkHttpClient, converterFactory: GsonConverterFactory): Retrofit =
      Retrofit.Builder().apply {
        client(client)
        baseUrl(baseUrl)
        addConverterFactory(converterFactory)
      }.build()

  @Singleton
  @Provides
  fun apiService(retrofit: Retrofit): MovieAPI = retrofit.create(MovieAPI::class.java)
}