package com.edwinnurwansyah.movies_detail.di

import com.edwinnurwansyah.data.di.LocalModule
import com.edwinnurwansyah.data.di.LocalScope
import com.edwinnurwansyah.data.local.MovieDao
import com.edwinnurwansyah.data.repository.movieFavorite.MovieFavoriteRepository
import com.edwinnurwansyah.data.repository.movieFavorite.MovieFavoriteRepositoryContract
import com.edwinnurwansyah.movies_detail.domain.usecase.DetailMovieUseCase
import com.edwinnurwansyah.movies_detail.domain.usecase.DetailMovieUseCaseContract

import dagger.Module
import dagger.Provides


@Module(includes = [LocalModule::class])
class DetailMovieModule {

    @DetailMovieScope
    @Provides
    fun provideRepository(@LocalScope movieDao: MovieDao): MovieFavoriteRepositoryContract {
        return MovieFavoriteRepository(movieDao)
    }

    @DetailMovieScope
    @Provides
    fun provideUseCase(repository: MovieFavoriteRepositoryContract): DetailMovieUseCaseContract {
        return DetailMovieUseCase(repository)
    }


}