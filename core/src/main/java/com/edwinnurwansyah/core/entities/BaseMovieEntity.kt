package com.edwinnurwansyah.core.entities

data class BaseMovieEntity(
    val page: Int,
    val moviesDataSourceApis: List<MovieEntity>,
    val totalPages: Int,
    val totalResults: Int
)