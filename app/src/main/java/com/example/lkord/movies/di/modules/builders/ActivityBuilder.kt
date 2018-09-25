package com.example.lkord.movies.di.modules.builders

import com.example.lkord.movies.di.ActivityScope
import com.example.lkord.movies.ui.home.HomeActivity
import com.example.lkord.movies.ui.moviedetails.MovieDetailsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector()
    internal abstract fun bindMainActivity(): HomeActivity

    @ActivityScope
    @ContributesAndroidInjector()
    internal abstract fun bindMovieDetailsActivity(): MovieDetailsActivity
}
