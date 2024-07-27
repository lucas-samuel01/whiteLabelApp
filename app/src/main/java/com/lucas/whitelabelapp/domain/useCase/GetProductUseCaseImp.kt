package com.lucas.whitelabelapp.domain.useCase

import com.lucas.whitelabelapp.data.ProductRepository
import com.lucas.whitelabelapp.domain.model.Product
import javax.inject.Inject

class GetProductUseCaseImp @Inject constructor(
    private val productRepository: ProductRepository
):GetProductsUseCase {

    override suspend fun invoke(): List<Product> {
        return productRepository.getProducts()
    }

}