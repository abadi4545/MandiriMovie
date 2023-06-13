package com.arkam.core.data.local.source.room.tv

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.arkam.core.data.local.source.room.movie.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TvDao {

    @Query("SELECT * FROM TvEntity")
    fun getFavoriteTv(): Flow<List<TvEntity>>

    @Query("SELECT * FROM TvEntity WHERE id LIKE :id")
    fun getFavoriteById(id: String): Flow<TvEntity>

    @Insert
    suspend fun insertFavoriteTv(tv: TvEntity)

    @Delete
    suspend fun deleteFavoriteTv(tv: TvEntity)
}