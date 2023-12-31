package com.arkam.movie.presentation.search

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.arkam.core.domain.model.Resource
import com.arkam.core.domain.model.movie.MovieResult
import com.arkam.core.domain.model.tv.TvResult
import com.arkam.core.domain.usecase.search.SearchUseCase

class SearchViewModel(
    val searchUseCase: SearchUseCase
): ViewModel() {
    val movieResponse = MediatorLiveData<Resource<MovieResult>>()
    val tvResponse = MediatorLiveData<Resource<TvResult>>()

    fun searchMovie(query: String, page: String = "1"){
        val source = LiveDataReactiveStreams.fromPublisher(
            searchUseCase.searchMovie(query, page)
        )

        movieResponse.addSource(source){
            movieResponse.postValue(it)
            movieResponse.removeSource(source)
        }
    }

    fun searchTv(query: String, page: String = "1"){
        val source = LiveDataReactiveStreams.fromPublisher(
            searchUseCase.searchTvShow(query, page)
        )

        tvResponse.addSource(source){
            tvResponse.postValue(it)
            tvResponse.removeSource(source)
        }
    }
}