package com.edwinnurwansyah.movie_favorite.domain.usecase

import androidx.lifecycle.LiveData
import com.edwinnurwansyah.core.entities.MovieEntity

interface MovieFavoriteUseCaseContract {

    fun getMovieFavorites(): LiveData<List<MovieEntity>>

    suspend fun saveMovieFavorit(movie: MovieEntity)

    suspend fun deleteMovieFavorit(movie: MovieEntity)


}