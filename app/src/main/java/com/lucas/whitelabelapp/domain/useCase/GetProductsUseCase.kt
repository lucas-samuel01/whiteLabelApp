package com.lucas.whitelabelapp.domain.useCase

import com.lucas.whitelabelapp.domain.model.Product

interface GetProductsUseCase  {
        suspend operator fun invoke():List<Product>
}