package com.arkam.core.domain.usecase.home

import com.arkam.core.domain.model.Resource
import com.arkam.core.domain.model.movie.MovieResult
import com.arkam.core.domain.model.tv.TvResult
import com.arkam.core.domain.repository.home.HomeRepository
import io.reactivex.rxjava3.core.Flowable

class HomeInteractor(
    private val homeRepository: HomeRepository
): HomeUseCase {
    override fun getMovies(category: String, page: String): Flowable<Resource<MovieResult>> {
        return homeRepository.getMovies(category, page)
    }

    override fun getTvShow(category: String, page: String): Flowable<Resource<TvResult>> {
        return homeRepository.getTvShow(category, page)
    }

    override fun saveRegion(region: String) {
        homeRepository.saveRegion(region)
    }
}