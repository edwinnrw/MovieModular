package com.edwinnurwansyah.movie_favorite.presentation.viewModel

import com.edwinnurwansyah.core.base.BaseViewModel
import com.edwinnurwansyah.movie_favorite.domain.usecase.MovieFavoriteUseCaseContract
import javax.inject.Inject

class MovieFavoriteViewModel @Inject constructor(
    private val useCase: MovieFavoriteUseCaseContract
) : BaseViewModel() {


    fun getAllMovieFavorite() = useCase.getMovieFavorites()

}