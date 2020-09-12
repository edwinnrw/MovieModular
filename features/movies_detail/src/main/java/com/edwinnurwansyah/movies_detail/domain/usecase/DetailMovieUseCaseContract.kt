package com.edwinnurwansyah.movies_detail.domain.usecase

import com.edwinnurwansyah.core.entities.MovieEntity
import com.edwinnurwansyah.data.local.MovieFavoriteEntity

interface DetailMovieUseCaseContract {


    suspend fun getMovieFavorite(id: Int): MovieFavoriteEntity?

    suspend fun saveMovieFavorit(movie: MovieEntity)

    suspend fun deleteMovieFavorit(movie: MovieEntity)


}