package com.arkam.core.di

import com.arkam.core.data.local.LocalDataSource
import com.arkam.core.data.remote.RemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    factory { RemoteDataSource(get()) }
    factory { LocalDataSource(get(), get()) }
}