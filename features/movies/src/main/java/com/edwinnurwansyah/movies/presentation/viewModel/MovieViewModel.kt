package com.edwinnurwansyah.movies.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import com.edwinnurwansyah.core.base.BaseViewModel
import com.edwinnurwansyah.core.base.ResultState
import com.edwinnurwansyah.core.entities.BaseMovieEntity
import com.edwinnurwansyah.movies.domain.usecase.MovieUseCaseContract
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val useCase: MovieUseCaseContract
) : BaseViewModel() {

    val stateResultLMovies = MutableLiveData<ResultState<BaseMovieEntity>>()


    fun getMovies(type: String) {
        when (type.toLowerCase()) {
            "now playing" -> {
                getMoviesNowPlaying()
            }
            "popular" -> {
                getMoviesPopular()
            }
            "upcoming" -> {
                getMoviesUpcoming()
            }
        }
    }

    private fun getMoviesNowPlaying() {
        val disposable = useCase.getMovieNowPlaying()
            .doOnSubscribe {
                stateResultLMovies.value = ResultState.Loading()
            }
            .subscribe { resultState ->
                stateResultLMovies.value = ResultState.HideLoading()
                stateResultLMovies.value = resultState

            }
        addDisposable(disposable)
    }

    private fun getMoviesUpcoming() {
        val disposable = useCase.getMovieUpcoming()
            .doOnSubscribe {
                stateResultLMovies.value = ResultState.Loading()
            }
            .subscribe { resultState ->
                stateResultLMovies.value = ResultState.HideLoading()
                stateResultLMovies.value = resultState

            }
        addDisposable(disposable)
    }

    private fun getMoviesPopular() {
        val disposable = useCase.getMovieTrending()
            .doOnSubscribe {
                stateResultLMovies.value = ResultState.Loading()
            }
            .subscribe { resultState ->
                stateResultLMovies.value = ResultState.HideLoading()
                stateResultLMovies.value = resultState

            }
        addDisposable(disposable)
    }

}