package com.arkam.core.domain.usecase.detail.movie

import com.arkam.core.domain.model.Resource
import com.arkam.core.domain.model.detail.*
import com.arkam.core.domain.model.movie.Movie
import com.arkam.core.domain.model.movie.MovieResult
import com.arkam.core.domain.model.tv.Tv
import com.arkam.core.domain.repository.detail.movie.MovieDetailRepository
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

class MovieDetailInteractor(
    private val movieDetailRepository: MovieDetailRepository
): MovieDetailUseCase {
    override fun getMovieDetail(id: String): Flowable<Resource<MovieDetail>> {
        return movieDetailRepository.getMovieDetail(id)
    }

    override fun getMovieReviews(id: String): Flowable<Resource<List<Review>>> {
        return movieDetailRepository.getMovieReviews(id)
    }

    override fun getMovieWallpapers(id: String): Flowable<Resource<Wallpaper>> {
        return movieDetailRepository.getMovieWallpapers(id)
    }

    override fun getMovieActors(id: String): Flowable<Resource<List<Actor>>> {
        return movieDetailRepository.getMovieActors(id)
    }

    override fun getMovieVideos(id: String): Flowable<Resource<List<Video>>> {
        return movieDetailRepository.getMovieVideos(id)
    }

    override fun isFollowed(id: String): Flow<Boolean> {
        return movieDetailRepository.isFollowed(id)
    }

    override fun insertFavoriteMovie(movie: Movie) {
        return movieDetailRepository.insertFavoriteMovie(movie)
    }

    override fun deleteFavoriteMovie(movie: Movie) {
        return movieDetailRepository.deleteFavoriteMovie(movie)
    }

    override fun getRecommendationsMovies(id: String): Flowable<Resource<MovieResult>> {
        return movieDetailRepository.getRecommendationsMovies(id)
    }

    override fun getSimilarMovies(id: String): Flowable<Resource<MovieResult>> {
        return movieDetailRepository.getSimilarMovies(id)
    }
}