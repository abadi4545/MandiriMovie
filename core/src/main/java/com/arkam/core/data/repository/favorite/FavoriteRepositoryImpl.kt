package com.arkam.core.data.repository.favorite

import com.arkam.core.domain.model.movie.Movie
import com.arkam.core.domain.model.tv.Tv
import com.arkam.core.domain.repository.favorite.FavoriteRepository
import kotlinx.coroutines.flow.Flow

class FavoriteRepositoryImpl: FavoriteRepository {
    override fun getFavoriteMovies(): Flow<List<Movie>> {
        TODO("Not yet implemented")
    }

    override fun getFavoriteTv(): Flow<List<Tv>> {
        TODO("Not yet implemented")
    }

}