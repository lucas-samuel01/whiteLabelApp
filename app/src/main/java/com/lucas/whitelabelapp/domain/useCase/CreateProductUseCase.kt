package com.lucas.whitelabelapp.domain.useCase

import android.net.Uri
import com.lucas.whitelabelapp.domain.model.Product

interface CreateProductUseCase {
     suspend operator fun invoke(description:String, price:Double, imageUri: Uri):Product
}