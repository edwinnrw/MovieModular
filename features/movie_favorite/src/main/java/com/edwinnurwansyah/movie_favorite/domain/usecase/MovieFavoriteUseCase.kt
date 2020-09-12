package com.edwinnurwansyah.movie_favorite.domain.usecase

import androidx.lifecycle.LiveData
import com.edwinnurwansyah.core.entities.MovieEntity
import com.edwinnurwansyah.core.util.map
import com.edwinnurwansyah.data.repository.movieFavorite.MovieFavoriteRepositoryContract
import com.edwinnurwansyah.movie_favorite.domain.mapper.movieFEntityMapItemToMovieFavoriteEntity
import com.edwinnurwansyah.movie_favorite.domain.mapper.movieFavoriteMapListToEntity


class MovieFavoriteUseCase(private val movieRepository: MovieFavoriteRepositoryContract) :
    MovieFavoriteUseCaseContract {
    override fun getMovieFavorites(): LiveData<List<MovieEntity>> {
        return movieRepository.getMovieFavorites().map {
            return@map movieFavoriteMapListToEntity(it)
        }
    }

    override suspend fun saveMovieFavorit(movie: MovieEntity) {
        val movieFavorit = movieFEntityMapItemToMovieFavoriteEntity(movie)
        movieRepository.saveMovieFavorit(movieFavorit)
    }

    override suspend fun deleteMovieFavorit(movie: MovieEntity) {
        val movieFavorit = movieFEntityMapItemToMovieFavoriteEntity(movie)
        movieRepository.deleteMovieFavorit(movieFavorit)
    }

}