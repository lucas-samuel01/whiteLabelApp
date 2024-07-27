package com.lucas.whitelabelapp.data.di

import com.lucas.whitelabelapp.data.FireBaseProjectDataSource
import com.lucas.whitelabelapp.data.ProductDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindProductDataSource(dataSource: FireBaseProjectDataSource):ProductDataSource
}