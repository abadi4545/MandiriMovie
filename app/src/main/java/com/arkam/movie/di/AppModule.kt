package com.arkam.movie.di

import com.arkam.core.domain.usecase.allmovietv.AllMovieTvInteractor
import com.arkam.core.domain.usecase.allmovietv.AllMovieTvUseCase
import com.arkam.core.domain.usecase.detail.movie.MovieDetailInteractor
import com.arkam.core.domain.usecase.detail.movie.MovieDetailUseCase
import com.arkam.core.domain.usecase.detail.tv.TvDetailInteractor
import com.arkam.core.domain.usecase.detail.tv.TvDetailUseCase
import com.arkam.core.domain.usecase.home.HomeInteractor
import com.arkam.core.domain.usecase.home.HomeUseCase
import com.arkam.core.domain.usecase.search.SearchInteractor
import com.arkam.core.domain.usecase.search.SearchUseCase
import com.arkam.movie.presentation.allmovietv.AllMovieTvViewModel
import com.arkam.movie.presentation.detail.DetailViewModel
import com.arkam.movie.presentation.home.HomeViewModel
import com.arkam.movie.presentation.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    single<HomeUseCase> { HomeInteractor(get()) }
    single<AllMovieTvUseCase> { AllMovieTvInteractor(get()) }
    single<MovieDetailUseCase> { MovieDetailInteractor(get()) }
    single<TvDetailUseCase> { TvDetailInteractor(get()) }
    single<SearchUseCase> { SearchInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get(), get()) }
    viewModel { AllMovieTvViewModel(get()) }
    viewModel { SearchViewModel(get()) }
}