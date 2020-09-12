package com.edwinnurwansyah.data.di

import com.edwinnurwansyah.core.network.NetworkHelper.retrofitClient
import com.edwinnurwansyah.data.api.RemoteApi
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    @NetworkScope
    fun provideServices(): RemoteApi {
        return retrofitClient().create(RemoteApi::class.java)
    }

}