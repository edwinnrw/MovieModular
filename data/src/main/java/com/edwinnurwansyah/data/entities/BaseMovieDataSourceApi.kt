package com.edwinnurwansyah.data.entities

import com.google.gson.annotations.SerializedName

data class BaseMovieDataSourceApi(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val moviesDataSourceApis: List<MovieDataSourceApi>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)