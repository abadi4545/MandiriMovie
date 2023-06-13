package com.arkam.core.domain.repository.home

import com.arkam.core.domain.model.Resource
import com.arkam.core.domain.model.movie.MovieResult
import com.arkam.core.domain.model.tv.TvResult
import io.reactivex.rxjava3.core.Flowable

interface HomeRepository {
    fun getMovies(category: String, page: String): Flowable<Resource<MovieResult>>
    fun getTvShow(category: String, page: String): Flowable<Resource<TvResult>>
    fun saveRegion(region: String)
}