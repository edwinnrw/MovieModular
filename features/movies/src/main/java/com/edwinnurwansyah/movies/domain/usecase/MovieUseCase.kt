package com.edwinnurwansyah.movies.domain.usecase

import com.edwinnurwansyah.core.base.ResultState
import com.edwinnurwansyah.core.entities.BaseMovieEntity
import com.edwinnurwansyah.core.util.singleIo
import com.edwinnurwansyah.data.repository.movies.MovieRepositoryContract
import com.edwinnurwansyah.movies.domain.mapper.responseBaseDataSourceApiToResultState
import io.reactivex.Single

class MovieUseCase(private val repository: MovieRepositoryContract) : MovieUseCaseContract {
    override fun getMovieNowPlaying(): Single<ResultState<BaseMovieEntity>> {
        return repository.getMovieNowPlaying().map {
            responseBaseDataSourceApiToResultState(it) { resultState ->
                resultState
            }
        }.onErrorReturn {
            return@onErrorReturn ResultState.Failed(it.message ?: "", null)
        }.compose(singleIo())
    }

    override fun getMovieUpcoming(): Single<ResultState<BaseMovieEntity>> {
        return repository.getMovieUpcoming().map {
            responseBaseDataSourceApiToResultState(it) { resultState ->
                resultState
            }
        }.onErrorReturn {
            return@onErrorReturn ResultState.Failed(it.message ?: "", null)
        }.compose(singleIo())
    }

    override fun getMovieTrending(): Single<ResultState<BaseMovieEntity>> {
        return repository.getMovieTrending().map {
            responseBaseDataSourceApiToResultState(it) { resultState ->
                resultState
            }
        }.onErrorReturn {
            return@onErrorReturn ResultState.Failed(it.message ?: "", null)
        }.compose(singleIo())
    }
}