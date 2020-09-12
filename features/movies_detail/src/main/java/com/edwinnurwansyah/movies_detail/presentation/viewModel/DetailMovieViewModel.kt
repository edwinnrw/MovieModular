package com.edwinnurwansyah.movies_detail.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.edwinnurwansyah.core.base.BaseViewModel
import com.edwinnurwansyah.core.entities.MovieEntity
import com.edwinnurwansyah.movies_detail.domain.usecase.DetailMovieUseCaseContract
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailMovieViewModel @Inject constructor(
    private val useCase: DetailMovieUseCaseContract
) : BaseViewModel() {

    val stateIsFavorite = MutableLiveData<Boolean>()

    fun checkIsFavorite(id: Int) {
        viewModelScope.launch {
            stateIsFavorite.value = useCase.getMovieFavorite(id) != null
        }

    }

    fun saveMovieFavorite(movie: MovieEntity) {
        viewModelScope.launch {
            useCase.saveMovieFavorit(movie)
        }
    }

    fun deleteMovieFavorite(movie: MovieEntity) {
        viewModelScope.launch {
            useCase.deleteMovieFavorit(movie)
        }
    }

}