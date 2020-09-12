package com.edwinnurwansyah.movie_favorite.presentation.ui


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.edwinnurwansyah.core.adapter.MovieAdapter
import com.edwinnurwansyah.core.base.BaseDaggerFragment
import com.edwinnurwansyah.core.entities.MovieEntity
import com.edwinnurwansyah.core.util.observe
import com.edwinnurwansyah.movie_favorite.R
import com.edwinnurwansyah.movie_favorite.di.DaggerMovieFavoriteComponent
import com.edwinnurwansyah.movie_favorite.presentation.viewModel.MovieFavoriteViewModel
import kotlinx.android.synthetic.main.fragment_movie_favorite.*
import javax.inject.Inject


class MovieFavoriteFragment : BaseDaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MovieFavoriteViewModel

    private lateinit var movieAdapter: MovieAdapter

    private lateinit var itemsMovie: MutableList<MovieEntity>

    override fun injectComponent() {
        DaggerMovieFavoriteComponent.factory().build(requireActivity().application)
            .inject(this)
    }

    override fun getViewLayoutResId(): Int {
        return R.layout.fragment_movie_favorite
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemsMovie = mutableListOf()
        movieAdapter = MovieAdapter(itemsMovie, requireContext())
        rvMovieFavorite.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)

        }
        viewModel =
            ViewModelProvider(this, viewModelFactory).get(MovieFavoriteViewModel::class.java)

        observe(viewModel.getAllMovieFavorite()) {
            itemsMovie.clear()
            itemsMovie.addAll(it)
            movieAdapter.notifyDataSetChanged()
        }
    }


}