package com.lucas.whitelabelapp.data

import android.net.Uri
import com.lucas.whitelabelapp.domain.model.Product

class ProductRepository(private val dataSource:ProductDataSource ) {

    suspend fun getProducts():List<Product> = dataSource.getProducts()

    suspend fun createProduct(product: Product): Product = dataSource.createProduct(product)

    suspend fun upLoadProductImage(imageUri: Uri):String = dataSource.upLoadProductImage(imageUri)
}