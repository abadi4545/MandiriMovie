package com.arkam.core.data.repository.home

import com.arkam.core.data.NetworkResource
import com.arkam.core.data.local.LocalDataSource
import com.arkam.core.data.remote.RemoteDataSource
import com.arkam.core.data.remote.source.response.movie.MovieResponse
import com.arkam.core.data.remote.source.response.tv.TvResponse
import com.arkam.core.domain.model.Resource
import com.arkam.core.domain.model.movie.MovieResult
import com.arkam.core.domain.model.tv.TvResult
import com.arkam.core.domain.repository.home.HomeRepository
import com.arkam.core.mapper.HomeMapper.map
import io.reactivex.rxjava3.core.Flowable

class HomeRepositoryImpl(
    val localDataSource: LocalDataSource,
    val remoteDataSource: RemoteDataSource
): HomeRepository {
    override fun getMovies(category: String, page: String): Flowable<Resource<MovieResult>> {
        return object : NetworkResource<MovieResult, MovieResponse>() {
            override fun createResult(data: MovieResponse): MovieResult {
                return data.map()
            }

            override fun createCall(): Flowable<MovieResponse> {
                return remoteDataSource.getMoviesByCategory(category, page)
            }

        }.asFlowable()
    }

    override fun getTvShow(category: String, page: String): Flowable<Resource<TvResult>> {
        return object : NetworkResource<TvResult, TvResponse>() {
            override fun createResult(data: TvResponse): TvResult {
                return data.map()
            }

            override fun createCall(): Flowable<TvResponse> {
                return remoteDataSource.getTvByCategory(category, page)
            }

        }.asFlowable()
    }

    override fun saveRegion(region: String) {
        TODO("Not yet implemented")
    }
}