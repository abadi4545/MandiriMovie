package com.arkam.core.domain.usecase.favorite

import com.arkam.core.domain.model.movie.Movie
import com.arkam.core.domain.model.tv.Tv
import com.arkam.core.domain.repository.favorite.FavoriteRepository
import kotlinx.coroutines.flow.Flow

class FavoriteInteractor(
    private val favoriteRepository: FavoriteRepository
): FavoriteUseCase {
    override fun getFavoriteMovies(): Flow<List<Movie>> {
        return favoriteRepository.getFavoriteMovies()
    }

    override fun getFavoriteTv(): Flow<List<Tv>> {
        return favoriteRepository.getFavoriteTv()
    }
}