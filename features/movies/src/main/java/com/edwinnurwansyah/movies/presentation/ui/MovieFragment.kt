package com.edwinnurwansyah.movies.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.edwinnurwansyah.core.adapter.MovieAdapter
import com.edwinnurwansyah.core.base.BaseDaggerFragment
import com.edwinnurwansyah.core.base.ResultState
import com.edwinnurwansyah.core.entities.BaseMovieEntity
import com.edwinnurwansyah.core.entities.MovieEntity
import com.edwinnurwansyah.core.util.makeGone
import com.edwinnurwansyah.core.util.makeVisible
import com.edwinnurwansyah.core.util.observe
import com.edwinnurwansyah.movies.R
import com.edwinnurwansyah.movies.di.DaggerMovieComponent
import com.edwinnurwansyah.movies.presentation.viewModel.MovieViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_movie.*
import javax.inject.Inject

class MovieFragment : BaseDaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MovieViewModel

    private lateinit var movieAdapter: MovieAdapter

    private lateinit var itemsMovie: MutableList<MovieEntity>

    override fun injectComponent() {
        DaggerMovieComponent.factory().build(requireActivity().application)
            .inject(this)
    }

    override fun getViewLayoutResId(): Int {
        return R.layout.fragment_movie
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemsMovie = mutableListOf()
        movieAdapter = MovieAdapter(itemsMovie, requireContext())
        rvMovies.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)

        }
        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieViewModel::class.java)
        observe(viewModel.stateResultLMovies, ::manageStateResponseMovies)

        tabLayout.addTab(tabLayout.newTab().setText("Now Playing"))
        tabLayout.addTab(tabLayout.newTab().setText("Popular"))
        tabLayout.addTab(tabLayout.newTab().setText("Upcoming"))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        itemsMovie.clear()
                        viewModel.getMovies("now playing")

                    }
                    1 -> {
                        itemsMovie.clear()
                        viewModel.getMovies("popular")

                    }
                    2 -> {
                        itemsMovie.clear()
                        viewModel.getMovies("upcoming")

                    }
                }
            }

        })
        viewModel.getMovies("now playing")

    }

    private fun manageStateResponseMovies(result: ResultState<BaseMovieEntity>) {
        when (result) {
            is ResultState.Loading -> {
                progressBar.makeVisible()
                rvMovies.makeGone()

            }
            is ResultState.Success -> {
                itemsMovie.addAll(result.data?.moviesDataSourceApis ?: mutableListOf())
                movieAdapter.notifyDataSetChanged()
            }
            is ResultState.HideLoading -> {
                progressBar.makeGone()
                rvMovies.makeVisible()
            }
            is ResultState.Failed -> {
                Toast.makeText(requireContext(), result.message, Toast.LENGTH_LONG).show()

            }
        }
    }


}