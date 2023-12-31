package com.arkam.core.data.local

import com.arkam.core.data.local.source.room.movie.MovieDao
import com.arkam.core.data.local.source.room.movie.MovieEntity
import com.arkam.core.data.local.source.room.tv.TvDao
import com.arkam.core.data.local.source.room.tv.TvEntity
import com.arkam.core.domain.model.movie.Movie
import kotlinx.coroutines.flow.Flow

class LocalDataSource(
    private val movieDao: MovieDao,
    private val tvDao: TvDao
) {

    fun getFavoriteMovie(): Flow<List<MovieEntity>>{
        return movieDao.getFavoriteMovie()
    }

    fun getMovieFavoriteById(id: String): Flow<MovieEntity?>{
        return movieDao.getFavoriteById(id)
    }

    suspend fun insertFavoriteMovie(movie: MovieEntity){
        movieDao.insertFavoriteMovie(movie)
    }

    suspend fun deleteFavoriteMovie(movie: MovieEntity){
        movieDao.deleteFavoriteMovie(movie)
    }
    fun getFavoriteTv(): Flow<List<TvEntity>>{
        return tvDao.getFavoriteTv()
    }

    fun getTvFavoriteById(id: String): Flow<TvEntity>{
        return tvDao.getFavoriteById(id)
    }

    suspend fun insertFavoriteTv(movie: TvEntity){
        tvDao.insertFavoriteTv(movie)
    }

    suspend fun deleteFavoriteTv(movie: TvEntity){
        tvDao.deleteFavoriteTv(movie)
    }

}