package com.edwinnurwansyah.movies_detail.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.edwinnurwansyah.core.util.ViewModelFactory
import com.edwinnurwansyah.core.util.ViewModelKey
import com.edwinnurwansyah.movies_detail.presentation.viewModel.DetailMovieViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DetailMovieViewModelModule {

    @DetailMovieScope
    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DetailMovieViewModel::class)
    internal abstract fun bindMovieViewModel(viewModel: DetailMovieViewModel): ViewModel

}