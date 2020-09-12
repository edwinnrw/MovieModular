package com.edwinnurwansyah.movies.di

import android.app.Application
import com.edwinnurwansyah.movies.presentation.ui.MovieFragment
import dagger.BindsInstance
import dagger.Component


@MovieScope
@Component(
    modules = [
        MovieModule::class,
        MovieViewModelModule::class
    ]
)
interface MovieComponent {
    @Component.Factory
    interface Builder {

        fun build(@BindsInstance application: Application): MovieComponent

    }

    fun inject(activity: MovieFragment)
} 