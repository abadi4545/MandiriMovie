package com.arkam.core.di

import com.arkam.core.data.repository.allmovie.AllMovieTvRepositoryImpl
import com.arkam.core.data.repository.detail.movie.MovieDetailRepositoryImpl
import com.arkam.core.data.repository.detail.tv.TvDetailRepositoryImpl
import com.arkam.core.data.repository.home.HomeRepositoryImpl
import com.arkam.core.data.repository.search.SearchRepositoryImpl
import com.arkam.core.domain.repository.allmovietv.AllMovieTvRepository
import com.arkam.core.domain.repository.detail.movie.MovieDetailRepository
import com.arkam.core.domain.repository.detail.tv.TvDetailRepository
import com.arkam.core.domain.repository.home.HomeRepository
import com.arkam.core.domain.repository.search.SearchRepository
import com.arkam.core.domain.usecase.allmovietv.AllMovieTvUseCase
import com.arkam.core.domain.usecase.detail.movie.MovieDetailInteractor
import org.koin.dsl.module

val repositoryModule = module {
    single<HomeRepository> { HomeRepositoryImpl(get(), get()) }
    single<MovieDetailRepository> { MovieDetailRepositoryImpl(get(), get()) }
    single<TvDetailRepository> { TvDetailRepositoryImpl(get(), get()) }
    single<AllMovieTvRepository> { AllMovieTvRepositoryImpl(get()) }
    single<SearchRepository> { SearchRepositoryImpl(get()) }
}