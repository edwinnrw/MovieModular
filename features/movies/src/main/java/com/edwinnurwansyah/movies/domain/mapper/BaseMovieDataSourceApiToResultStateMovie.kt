package com.edwinnurwansyah.movies.domain.mapper

import com.edwinnurwansyah.core.base.ResultState
import com.edwinnurwansyah.core.entities.BaseMovieEntity
import com.edwinnurwansyah.core.entities.MovieEntity
import com.edwinnurwansyah.data.entities.BaseMovieDataSourceApi
import com.edwinnurwansyah.data.entities.MovieDataSourceApi

fun responseBaseDataSourceApiToResultState(
    baseDataSourceApi: BaseMovieDataSourceApi,
    onSuccess: (ResultState<BaseMovieEntity>) -> ResultState<BaseMovieEntity>
): ResultState<BaseMovieEntity> {
    onSuccess(ResultState.Success(mapBaseMovieItemToEntity(baseDataSourceApi)))
    return ResultState.Success(mapBaseMovieItemToEntity(baseDataSourceApi))

}

private fun mapBaseMovieItemToEntity(item: BaseMovieDataSourceApi): BaseMovieEntity =
    BaseMovieEntity(
        page = item.page ?: 0,
        moviesDataSourceApis = movieMapListToEntity(item.moviesDataSourceApis ?: mutableListOf()),
        totalPages = item.totalPages ?: 0,
        totalResults = item.totalResults ?: 0

    )

fun movieMapListToEntity(movies: List<MovieDataSourceApi>): List<MovieEntity> =
    movies.map { mapItemToEntity(it) }

private fun mapItemToEntity(item: MovieDataSourceApi): MovieEntity =
    MovieEntity(
        id = item.id ?: 0,
        adult = item.adult ?: false,
        backdropPath = item.backdropPath ?: "",
        originalTitle = item.originalTitle ?: "",
        overview = item.overview ?: "",
        popularity = item.popularity ?: 0.0,
        posterPath = item.posterPath ?: "",
        releaseDate = item.releaseDate ?: "",
        title = item.title ?: "",
        video = item.video ?: false,
        voteAverage = item.voteAverage ?: 0.0,
        voteCount = item.voteCount ?: 0
    )