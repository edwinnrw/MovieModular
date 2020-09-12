package com.edwinnurwansyah.movie_favorite.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.edwinnurwansyah.movie_favorite.R

class MainMovieFavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_movie_favorite)
        title = "Favorite"

    }
}