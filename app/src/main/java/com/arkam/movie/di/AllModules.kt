package com.arkam.core.di

import com.arkam.movie.di.useCaseModule
import com.arkam.movie.di.viewModelModule

val listModules = listOf(
    databaseModule,
    networkModule,
    repositoryModule,
    dataSourceModule,
    useCaseModule,
    viewModelModule
)