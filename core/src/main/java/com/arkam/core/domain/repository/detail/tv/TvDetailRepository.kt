package com.arkam.core.domain.repository.detail.tv

import com.arkam.core.domain.model.Resource
import com.arkam.core.domain.model.detail.*
import com.arkam.core.domain.model.movie.Movie
import com.arkam.core.domain.model.tv.Tv
import com.arkam.core.domain.model.tv.TvResult
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

interface TvDetailRepository {
    fun getTvDetail(id: String): Flowable<Resource<TvDetail>>
    fun getTvReviews(id: String): Flowable<Resource<List<Review>>>
    fun getTvWallpapers(id: String): Flowable<Resource<Wallpaper>>
    fun getTvActors(id: String): Flowable<Resource<List<Actor>>>
    fun getTvVideos(id: String): Flowable<Resource<List<Video>>>

    fun isFollowed(id: String): Flow<Boolean>

    fun insertFavoriteTv(tv: Tv)
    fun deleteFavoriteTv(tv: Tv)

    fun getRecommendationsTv(id: String): Flowable<Resource<TvResult>>
    fun getSimilarTv(id: String): Flowable<Resource<TvResult>>
}