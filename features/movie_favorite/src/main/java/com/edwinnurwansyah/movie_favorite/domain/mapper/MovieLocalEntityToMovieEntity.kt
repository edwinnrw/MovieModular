package com.edwinnurwansyah.movie_favorite.domain.mapper

import com.edwinnurwansyah.core.entities.MovieEntity
import com.edwinnurwansyah.data.local.MovieFavoriteEntity

fun movieFavoriteMapListToEntity(movies: List<MovieFavoriteEntity>): List<MovieEntity> =
    movies.map { mapItemToEntity(it) }

private fun mapItemToEntity(item: MovieFavoriteEntity): MovieEntity =
    MovieEntity(
        id = item.id,
        adult = item.adult,
        backdropPath = item.backdropPath,
        originalTitle = item.originalTitle,
        overview = item.overview,
        popularity = item.popularity,
        posterPath = item.posterPath,
        releaseDate = item.releaseDate,
        title = item.title,
        video = item.video,
        voteAverage = item.voteAverage,
        voteCount = item.voteCount
    )

fun movieFEntityMapItemToMovieFavoriteEntity(item: MovieEntity): MovieFavoriteEntity =
    MovieFavoriteEntity(
        id = item.id,
        adult = item.adult,
        backdropPath = item.backdropPath,
        originalTitle = item.originalTitle,
        overview = item.overview,
        popularity = item.popularity,
        posterPath = item.posterPath,
        releaseDate = item.releaseDate,
        title = item.title,
        video = item.video,
        voteAverage = item.voteAverage,
        voteCount = item.voteCount
    )