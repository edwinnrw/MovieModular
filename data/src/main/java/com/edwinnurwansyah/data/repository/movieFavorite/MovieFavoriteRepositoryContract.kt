package com.edwinnurwansyah.data.repository.movieFavorite

import androidx.lifecycle.LiveData
import com.edwinnurwansyah.data.local.MovieFavoriteEntity

interface MovieFavoriteRepositoryContract {

    fun getMovieFavorites(): LiveData<List<MovieFavoriteEntity>>

    suspend fun getMovieFavorite(id: Int): MovieFavoriteEntity?

    suspend fun saveMovieFavorit(movie: MovieFavoriteEntity)

    suspend fun deleteMovieFavorit(movie: MovieFavoriteEntity)


}