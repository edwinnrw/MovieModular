package com.edwinnurwansyah.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_favorite_items ORDER BY title ASC")
    fun getAll(): LiveData<List<MovieFavoriteEntity>>

    @Query("SELECT * FROM movie_favorite_items WHERE id=:id")
    suspend fun getMovie(id: Int): MovieFavoriteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg movies: MovieFavoriteEntity)

    @Delete
    suspend fun delete(movie: MovieFavoriteEntity)

    @Update
    suspend fun update(vararg movies: MovieFavoriteEntity)
}