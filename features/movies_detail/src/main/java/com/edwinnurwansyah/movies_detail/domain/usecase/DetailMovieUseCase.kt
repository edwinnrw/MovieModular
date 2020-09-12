package com.edwinnurwansyah.movies_detail.domain.usecase

import com.edwinnurwansyah.core.entities.MovieEntity
import com.edwinnurwansyah.data.local.MovieFavoriteEntity
import com.edwinnurwansyah.data.repository.movieFavorite.MovieFavoriteRepositoryContract
import com.edwinnurwansyah.movies_detail.domain.mapper.movieFavoriteEntityMapItemToMovieFavoriteEntity


class DetailMovieUseCase(private val movieRepository: MovieFavoriteRepositoryContract) :
    DetailMovieUseCaseContract {
    override suspend fun getMovieFavorite(id: Int): MovieFavoriteEntity? {
        return movieRepository.getMovieFavorite(id)
    }


    override suspend fun saveMovieFavorit(movie: MovieEntity) {
        val movieFavorit = movieFavoriteEntityMapItemToMovieFavoriteEntity(movie)
        movieRepository.saveMovieFavorit(movieFavorit)
    }

    override suspend fun deleteMovieFavorit(movie: MovieEntity) {
        val movieFavorit = movieFavoriteEntityMapItemToMovieFavoriteEntity(movie)
        movieRepository.deleteMovieFavorit(movieFavorit)
    }

}