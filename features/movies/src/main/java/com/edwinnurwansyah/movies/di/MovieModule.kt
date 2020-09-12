package com.edwinnurwansyah.movies.di

import com.edwinnurwansyah.data.api.RemoteApi
import com.edwinnurwansyah.data.di.NetworkModule
import com.edwinnurwansyah.data.di.NetworkScope
import com.edwinnurwansyah.data.repository.movies.MovieRepository
import com.edwinnurwansyah.data.repository.movies.MovieRepositoryContract
import com.edwinnurwansyah.movies.domain.usecase.MovieUseCase
import com.edwinnurwansyah.movies.domain.usecase.MovieUseCaseContract
import dagger.Module
import dagger.Provides


@Module(includes = [NetworkModule::class])
class MovieModule {

    @MovieScope
    @Provides
    fun provideRepository(@NetworkScope service: RemoteApi): MovieRepositoryContract {
        return MovieRepository(service)
    }

    @MovieScope
    @Provides
    fun provideUseCase(repository: MovieRepositoryContract): MovieUseCaseContract {
        return MovieUseCase(repository)
    }


}