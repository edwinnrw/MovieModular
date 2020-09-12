package com.edwinnurwansyah.movie_favorite.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.edwinnurwansyah.core.util.ViewModelFactory
import com.edwinnurwansyah.core.util.ViewModelKey
import com.edwinnurwansyah.movie_favorite.presentation.viewModel.MovieFavoriteViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MovieFavoriteViewModelModule {

    @MovieFavoriteScope
    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieFavoriteViewModel::class)
    internal abstract fun bindMovieViewModel(viewModel: MovieFavoriteViewModel): ViewModel

}