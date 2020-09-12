package com.edwinnurwansyah.moviemodular

import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.edwinnurwansyah.core.util.navigateUriWithDefaultOptions

class MainActivity : AppCompatActivity() {
    var menuFavorite: MenuItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.nav_host_fragment)
        navController.addOnDestinationChangedListener { controller, _, _ ->
            val id = controller.currentDestination?.id
            if (id == R.id.movie_fragment) {
                menuFavorite?.isVisible = true
                title = "E-Movie"
            }
            if (id == R.id.movie_favorite_fragment) {
                menuFavorite?.isVisible = false
                title = "Favorite"
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        menuFavorite = menu.findItem(R.id.menu_favorite)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_favorite -> {
                findNavController(R.id.nav_host_fragment).navigateUriWithDefaultOptions(
                    Uri.parse("moviemodular://feature_movie_favorite")
                )
            }
        }
        return super.onOptionsItemSelected(item)
    }


}