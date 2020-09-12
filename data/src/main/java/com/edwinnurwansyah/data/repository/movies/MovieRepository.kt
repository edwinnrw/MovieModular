package com.edwinnurwansyah.data.repository.movies

import com.edwinnurwansyah.data.api.RemoteApi

class MovieRepository(private val api: RemoteApi) : MovieRepositoryContract {

    override fun getMovieNowPlaying() = api.getNowPlaying()

    override fun getMovieUpcoming() = api.getUpcoming()

    override fun getMovieTrending() = api.getTrending()

}