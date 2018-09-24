package com.example.lkord.movies.di.modules.builders

import com.example.lkord.movies.ui.nowPlaying.view.NowPlayingFragment
import com.example.lkord.movies.ui.popular.PopularFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector()
    internal abstract fun bindNowPlayingFragment(): NowPlayingFragment

    @ContributesAndroidInjector()
    internal abstract fun bindPopularFragment(): PopularFragment
}