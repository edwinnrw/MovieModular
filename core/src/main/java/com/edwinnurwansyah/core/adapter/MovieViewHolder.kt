package com.edwinnurwansyah.core.adapter

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.edwinnurwansyah.core.BuildConfig
import com.edwinnurwansyah.core.entities.MovieEntity
import com.edwinnurwansyah.core.util.loadImage
import com.edwinnurwansyah.core.util.navigateUriWithDefaultOptions
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieViewHolder(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView) {

    fun bindTo(item: MovieEntity) {

        itemView.apply {
            ivImage.loadImage(BuildConfig.IMAGE_URL + item.posterPath)
            tvRate.text = item.voteAverage.toString()
            Log.d("MOVIE_TITLE", item.title)
            Log.d("MOVIE_DATE", item.releaseDate)
            setOnClickListener {
                findNavController().navigateUriWithDefaultOptions(
                    Uri.parse(
                        "moviemodular://feature_detail_movie/${item.id}/${item.voteAverage}/${item.overview}" +
                                "/${item.releaseDate}/${item.title},${item.backdropPath},${item.posterPath}"
                    )
                )
            }
        }
    }
}