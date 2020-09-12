package com.edwinnurwansyah.data.api

import com.edwinnurwansyah.data.entities.BaseMovieDataSourceApi
import io.reactivex.Single
import retrofit2.http.GET

interface RemoteApi {
    @GET("./3/movie/now_playing")
    fun getNowPlaying(): Single<BaseMovieDataSourceApi>

    @GET("./3/movie/upcoming")
    fun getUpcoming(): Single<BaseMovieDataSourceApi>

    @GET("./3/movie/popular")
    fun getTrending(): Single<BaseMovieDataSourceApi>
}