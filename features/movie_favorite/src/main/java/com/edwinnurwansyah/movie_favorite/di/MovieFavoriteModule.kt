package com.edwinnurwansyah.movie_favorite.di

import com.edwinnurwansyah.data.di.LocalModule
import com.edwinnurwansyah.data.di.LocalScope
import com.edwinnurwansyah.data.local.MovieDao
import com.edwinnurwansyah.data.repository.movieFavorite.MovieFavoriteRepository
import com.edwinnurwansyah.data.repository.movieFavorite.MovieFavoriteRepositoryContract
import com.edwinnurwansyah.movie_favorite.domain.usecase.MovieFavoriteUseCase
import com.edwinnurwansyah.movie_favorite.domain.usecase.MovieFavoriteUseCaseContract

import dagger.Module
import dagger.Provides


@Module(includes = [LocalModule::class])
class MovieFavoriteModule {

    @MovieFavoriteScope
    @Provides
    fun provideRepository(@LocalScope movieDao: MovieDao): MovieFavoriteRepositoryContract {
        return MovieFavoriteRepository(movieDao)
    }

    @MovieFavoriteScope
    @Provides
    fun provieMovieFavoriteUseCase(repository: MovieFavoriteRepositoryContract): MovieFavoriteUseCaseContract {
        return MovieFavoriteUseCase(repository)
    }


}