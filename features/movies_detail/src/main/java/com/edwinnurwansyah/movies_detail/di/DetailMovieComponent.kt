package com.edwinnurwansyah.movies_detail.di

import android.app.Application
import com.edwinnurwansyah.movies_detail.presentation.DetailMovieActivity
import dagger.BindsInstance
import dagger.Component

@DetailMovieScope
@Component(
    modules = [
        DetailMovieModule::class,
        DetailMovieViewModelModule::class
    ]
)
interface DetailMovieComponent {
    @Component.Factory
    interface Builder {

        fun build(@BindsInstance application: Application): DetailMovieComponent

    }

    fun inject(activity: DetailMovieActivity)
}