package com.example.lkord.movies.di.modules.builders

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.lkord.movies.di.DaggerAwareViewModelFactory
import com.example.lkord.movies.di.ViewModelKey
import com.example.lkord.movies.viewModels.NowPlayingViewModel
import com.example.lkord.movies.viewModels.PopularViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelBuilder {

    @Binds
    internal abstract fun bindViewModelFactory(factory: DaggerAwareViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(NowPlayingViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: NowPlayingViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(PopularViewModel::class)
    internal abstract fun bindPopularViewModel(viewModel: PopularViewModel): ViewModel
}
