package com.arkam.core.domain.repository.favorite

import com.arkam.core.domain.model.movie.Movie
import com.arkam.core.domain.model.tv.Tv
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    fun getFavoriteMovies(): Flow<List<Movie>>
    fun getFavoriteTv(): Flow<List<Tv>>


}