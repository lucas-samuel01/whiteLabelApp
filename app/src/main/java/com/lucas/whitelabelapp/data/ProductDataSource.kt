package com.lucas.whitelabelapp.data

import android.net.Uri
import com.lucas.whitelabelapp.domain.model.Product

interface ProductDataSource {

    suspend fun getProducts():List<Product>

    suspend fun createProduct(product: Product):Product

    suspend fun upLoadProductImage(imageUri: Uri):String
}