package com.edwinnurwansyah.movies_detail.presentation

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navArgs
import com.edwinnurwansyah.core.BuildConfig
import com.edwinnurwansyah.core.base.BaseDaggerActivity
import com.edwinnurwansyah.core.entities.MovieEntity
import com.edwinnurwansyah.core.util.loadImage
import com.edwinnurwansyah.core.util.observe
import com.edwinnurwansyah.movies_detail.R
import com.edwinnurwansyah.movies_detail.di.DaggerDetailMovieComponent
import com.edwinnurwansyah.movies_detail.presentation.viewModel.DetailMovieViewModel
import kotlinx.android.synthetic.main.activity_detail_movie.*
import javax.inject.Inject


class DetailMovieActivity : BaseDaggerActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: DetailMovieViewModel

    private val args by navArgs<DetailMovieActivityArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailMovieViewModel::class.java)
        ivPoster.loadImage(BuildConfig.IMAGE_URL + args.backdrop)
        tvOverview.text = args.overview.trim()
        tvTitle.text = args.title
        tvDate.text = args.date
        observe(viewModel.stateIsFavorite) {
            cbFavorite.isChecked = it
        }
        val movie = MovieEntity(
            adult = false,
            backdropPath = args.backdrop,
            id = args.movieId,
            originalTitle = "",
            overview = args.overview,
            popularity = 0.0,
            posterPath = args.poster,
            releaseDate = args.date,
            title = args.title,
            video = false,
            voteAverage = args.voteAverage.toDouble(),
            voteCount = 0
        )

        viewModel.checkIsFavorite(args.movieId)

        cbFavorite.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                viewModel.saveMovieFavorite(movie)
            } else {
                viewModel.deleteMovieFavorite(movie)

            }
        }

    }

    override fun injectComponent() {
        DaggerDetailMovieComponent.factory()
            .build(application).inject(this)

    }

    override fun getViewLayoutResId(): Int {
        return R.layout.activity_detail_movie
    }

}
