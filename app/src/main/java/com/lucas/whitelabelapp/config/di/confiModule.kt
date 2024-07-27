package com.lucas.whitelabelapp.config.di

import com.lucas.whitelabelapp.config.Config
import com.lucas.whitelabelapp.config.ConfigImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface confiModule {

    @Binds
    fun bindConfig  (config: ConfigImp): Config
}