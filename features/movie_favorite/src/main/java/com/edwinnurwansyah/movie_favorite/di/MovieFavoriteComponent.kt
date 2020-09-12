package com.edwinnurwansyah.movie_favorite.di

import android.app.Application
import com.edwinnurwansyah.movie_favorite.presentation.ui.MovieFavoriteFragment
import dagger.BindsInstance
import dagger.Component

@MovieFavoriteScope
@Component(
    modules = [
        MovieFavoriteModule::class,
        MovieFavoriteViewModelModule::class
    ]
)
interface MovieFavoriteComponent {
    @Component.Factory
    interface Builder {

        fun build(@BindsInstance application: Application): MovieFavoriteComponent

    }

    fun inject(activity: MovieFavoriteFragment)
}