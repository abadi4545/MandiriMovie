package com.arkam.core.domain.usecase.allmovietv

import com.arkam.core.domain.model.Resource
import com.arkam.core.domain.model.movie.MovieResult
import com.arkam.core.domain.model.tv.TvResult
import io.reactivex.rxjava3.core.Flowable

interface AllMovieTvUseCase {
    fun getMovies(category: String, page: String): Flowable<Resource<MovieResult>>
    fun getTvShow(category: String, page: String): Flowable<Resource<TvResult>>
}