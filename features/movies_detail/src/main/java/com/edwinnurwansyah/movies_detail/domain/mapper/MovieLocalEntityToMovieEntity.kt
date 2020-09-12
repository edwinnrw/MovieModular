package com.edwinnurwansyah.movies_detail.domain.mapper

import com.edwinnurwansyah.core.entities.MovieEntity
import com.edwinnurwansyah.data.local.MovieFavoriteEntity


fun movieFavoriteEntityMapItemToMovieFavoriteEntity(item: MovieEntity): MovieFavoriteEntity =
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