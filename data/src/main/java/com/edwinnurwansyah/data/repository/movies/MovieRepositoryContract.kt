package com.edwinnurwansyah.data.repository.movies

import com.edwinnurwansyah.data.entities.BaseMovieDataSourceApi
import io.reactivex.Single

interface MovieRepositoryContract {

    fun getMovieNowPlaying(): Single<BaseMovieDataSourceApi>

    fun getMovieUpcoming(): Single<BaseMovieDataSourceApi>

    fun getMovieTrending(): Single<BaseMovieDataSourceApi>


}