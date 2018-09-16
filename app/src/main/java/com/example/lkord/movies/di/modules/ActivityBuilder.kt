package com.example.lkord.movies.di.modules

import com.example.lkord.movies.di.ActivityScope
import com.example.lkord.movies.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@ActivityScope
@Module
internal abstract class ActivityBuilder {


    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainActivity
}
