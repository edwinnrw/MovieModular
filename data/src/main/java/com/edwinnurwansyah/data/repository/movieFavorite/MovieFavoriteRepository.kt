package com.edwinnurwansyah.data.repository.movieFavorite

import androidx.lifecycle.LiveData
import com.edwinnurwansyah.data.local.MovieDao
import com.edwinnurwansyah.data.local.MovieFavoriteEntity

class MovieFavoriteRepository(private val movieDao: MovieDao) : MovieFavoriteRepositoryContract {
    override fun getMovieFavorites(): LiveData<List<MovieFavoriteEntity>> {
        return movieDao.getAll()
    }

    override suspend fun getMovieFavorite(id: Int): MovieFavoriteEntity? {
        return movieDao.getMovie(id)
    }

    override suspend fun saveMovieFavorit(movie: MovieFavoriteEntity) {
        movieDao.insert(movie)
    }

    override suspend fun deleteMovieFavorit(movie: MovieFavoriteEntity) {
        movieDao.delete(movie)

    }
}