package com.example.lkord.movies.di.modules

import com.example.data.networking.MovieAPI
import com.example.lkord.movies.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

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

  @Provides
  fun authenticationInterceptor() = Interceptor {
    val request = it.request().newBuilder().apply {
      addHeader(KEY_AUTHORIZATION, "Bearer ${BuildConfig.TMDB_API_TOKEN}")
    }.build()
    it.proceed(request)
  }

  @Singleton
  @Provides
  fun okhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, authInterceptor: Interceptor): OkHttpClient {
   return OkHttpClient.Builder().apply {
      if (BuildConfig.DEBUG) addInterceptor(httpLoggingInterceptor)
      addInterceptor(authInterceptor)
    }.build()
  }

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

private const val BASE_URL = "https://api.themoviedb.org/3/"
private const val KEY_AUTHORIZATION = "Authorization"