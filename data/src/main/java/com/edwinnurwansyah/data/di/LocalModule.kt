package com.edwinnurwansyah.data.di

import android.app.Application
import com.edwinnurwansyah.data.local.MovieDao
import com.edwinnurwansyah.data.local.MovieDatabase
import dagger.Module
import dagger.Provides

@Module
class LocalModule {

    @Provides
    @LocalScope
    fun provideDatabase(application: Application): MovieDao {
        return MovieDatabase.getInstance(application).movieDao()
    }

}