package com.arkam.core.domain.usecase.search

import com.arkam.core.domain.model.Resource
import com.arkam.core.domain.model.movie.MovieResult
import com.arkam.core.domain.model.tv.TvResult
import io.reactivex.rxjava3.core.Flowable


interface SearchUseCase {
    fun searchMovie(query: String, page: String): Flowable<Resource<MovieResult>>
    fun searchTvShow(query: String, page: String): Flowable<Resource<TvResult>>
}