package com.edwinnurwansyah.core.util

import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigator
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.edwinnurwansyah.core.R

fun ImageView.loadImage(url: String) {
    val requestOptions = RequestOptions.placeholderOf(R.drawable.ic_baseline_image_24)
    Glide.with(context)
        .load(url)
        .apply(requestOptions)
        .into(this)
}

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeGone() {
    visibility = View.GONE
}

fun createDefaultNavOptions(destination: Int) = NavOptions.Builder()
    .setLaunchSingleTop(false)
    .setPopUpTo(destination, false)
    .setEnterAnim(R.anim.nav_default_enter_anim)
    .setExitAnim(R.anim.nav_default_exit_anim)
    .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
    .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
    .build()

fun NavController.navigateUriWithDefaultOptions(
    uri: Uri,
    extras: FragmentNavigator.Extras? = null
) {
    this.navigate(uri, createDefaultNavOptions(this.currentDestination?.id ?: -1), extras)
}

fun <X, Y> LiveData<X>.map(func: (source: X) -> Y) = Transformations.map(this, func)
