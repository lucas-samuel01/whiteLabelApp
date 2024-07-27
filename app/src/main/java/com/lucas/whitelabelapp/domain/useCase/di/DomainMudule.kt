package com.lucas.whitelabelapp.domain.useCase.di

import androidx.lifecycle.ViewModel
import com.lucas.whitelabelapp.domain.useCase.CreateProductUseCase
import com.lucas.whitelabelapp.domain.useCase.CreateProductUseCaseImp
import com.lucas.whitelabelapp.domain.useCase.GetProductUseCaseImp
import com.lucas.whitelabelapp.domain.useCase.GetProductsUseCase
import com.lucas.whitelabelapp.domain.useCase.UploadProductImageUsecase
import com.lucas.whitelabelapp.domain.useCase.UploadeProductImageUseCaseImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainMudule  {

    @Binds
    fun bindCreateProductUseCase(useCase: CreateProductUseCaseImp):CreateProductUseCase

    @Binds
    fun bindGetProductsUsecase(useCase:GetProductUseCaseImp): GetProductsUseCase

    @Binds
    fun bindUploadProductImageUseCase(imageUsecase:UploadeProductImageUseCaseImp):UploadProductImageUsecase
}