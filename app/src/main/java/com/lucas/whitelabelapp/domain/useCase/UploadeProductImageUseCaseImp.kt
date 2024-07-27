package com.lucas.whitelabelapp.domain.useCase

import android.net.Uri
import com.lucas.whitelabelapp.data.ProductRepository
import javax.inject.Inject

class UploadeProductImageUseCaseImp @Inject constructor(
    private val productRepository: ProductRepository
):UploadProductImageUsecase{
    override suspend fun invoke(imageUri: Uri): String {
       return productRepository.upLoadProductImage(imageUri)
    }
}