package com.lucas.whitelabelapp.domain.useCase

import android.net.Uri
import com.lucas.whitelabelapp.data.ProductRepository
import com.lucas.whitelabelapp.domain.model.Product
import java.util.UUID
import javax.inject.Inject

class CreateProductUseCaseImp @Inject constructor(
    private val uploadImageUsecase: UploadProductImageUsecase,
    private val productRepository: ProductRepository
):CreateProductUseCase {
    override suspend fun invoke(description: String, price: Double, imageUri: Uri): Product {
          return try{
            val imageUrl = uploadImageUsecase(imageUri)
            val product = Product(UUID.randomUUID().toString(), description, price, imageUrl)
            productRepository.createProduct(product)
        }catch (e:Exception){
            throw  e
        }
    }
}