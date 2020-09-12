package com.edwinnurwansyah.movies.domain.usecase

import com.edwinnurwansyah.core.base.ResultState
import com.edwinnurwansyah.core.entities.BaseMovieEntity
import io.reactivex.Single

interface MovieUseCaseContract {
    fun getMovieNowPlaying(): Single<ResultState<BaseMovieEntity>>

    fun getMovieUpcoming(): Single<ResultState<BaseMovieEntity>>

    fun getMovieTrending(): Single<ResultState<BaseMovieEntity>>
}