package com.edwinnurwansyah.core.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edwinnurwansyah.core.R
import com.edwinnurwansyah.core.entities.MovieEntity


class MovieAdapter(private val listItems: List<MovieEntity>, val context: Context) :
    RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView, context)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindTo(listItems[position])

    }
}