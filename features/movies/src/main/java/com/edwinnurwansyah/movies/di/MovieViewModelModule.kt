package com.edwinnurwansyah.movies.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.edwinnurwansyah.core.util.ViewModelFactory
import com.edwinnurwansyah.core.util.ViewModelKey
import com.edwinnurwansyah.movies.presentation.viewModel.MovieViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class MovieViewModelModule {

    @MovieScope
    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    internal abstract fun bindMovieViewModel(viewModel: MovieViewModel): ViewModel

}