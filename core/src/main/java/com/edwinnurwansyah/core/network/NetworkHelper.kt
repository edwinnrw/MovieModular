package com.edwinnurwansyah.core.network

import com.edwinnurwansyah.core.BuildConfig
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkHelper {
    fun retrofitClient(url: String = BuildConfig.MOVIE_URL): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient())
            .build()
    }

    private fun okHttpClient(): OkHttpClient {
        val certificatePinner = CertificatePinner.Builder()
            .add("api.themoviedb.org", "sha256/HkCBucsA3Tgiby96X7vjb/ojHaE1BrjvZ2+LRdJJd0E=")
            .add("image.tmdb.org", "sha256/iWL1FphmSxEqNiQzXjWGlsmA0ksR0158Bl0VbujVuDc=")
            .build()
        val okhttp = OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .certificatePinner(certificatePinner)
            .addInterceptor(NetworkInterceptor())
            .addInterceptor(createLoggingInterceptor())
            .pingInterval(30, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)

        return okhttp.build()
    }

    private fun createLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}