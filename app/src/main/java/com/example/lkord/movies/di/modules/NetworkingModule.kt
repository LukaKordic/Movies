package com.example.lkord.movies.di.modules

import android.annotation.SuppressLint
import com.example.data.networking.MovieAPI
import com.example.lkord.movies.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@SuppressLint("JvmStaticProvidesInObjectDetector")
//If every method is static then compiler doesn't have to generate an instance of DatabaseModule (just a small optimization)
@Module
@InstallIn(ApplicationComponent::class)
object NetworkingModule {
  
  @Singleton
  @Provides
  @JvmStatic
  fun baseUrl(): String = BASE_URL
  
  @Singleton
  @Provides
  @JvmStatic
  fun converterFactory(): GsonConverterFactory = GsonConverterFactory.create()
  
  @Singleton
  @Provides
  @JvmStatic
  fun httpLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
      level = HttpLoggingInterceptor.Level.HEADERS
    }
  }
  
  @Singleton
  @Provides
  @JvmStatic
  fun authenticationInterceptor() = Interceptor {
    val request = it.request().newBuilder().apply {
      addHeader(KEY_AUTHORIZATION, "Bearer ${BuildConfig.TMDB_API_TOKEN}")
    }.build()
    it.proceed(request)
  }
  
  @Singleton
  @Provides
  @JvmStatic
  fun okhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, authInterceptor: Interceptor): OkHttpClient {
    return OkHttpClient.Builder().apply {
      if (BuildConfig.DEBUG) addInterceptor(httpLoggingInterceptor)
      addNetworkInterceptor(authInterceptor)
    }.build()
  }
  
  @Singleton
  @Provides
  @JvmStatic
  fun retrofit(baseUrl: String, client: OkHttpClient, converterFactory: GsonConverterFactory): Retrofit =
    Retrofit.Builder().apply {
      client(client)
      baseUrl(baseUrl)
      addConverterFactory(converterFactory)
    }.build()
  
  @Singleton
  @Provides
  @JvmStatic
  fun apiService(retrofit: Retrofit): MovieAPI = retrofit.create(MovieAPI::class.java)
}

private const val BASE_URL = "https://api.themoviedb.org/3/"
private const val KEY_AUTHORIZATION = "Authorization"