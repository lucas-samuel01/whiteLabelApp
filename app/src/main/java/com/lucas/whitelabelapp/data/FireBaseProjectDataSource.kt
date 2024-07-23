package com.lucas.whitelabelapp.data

import android.net.Uri
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.google.firebase.storage.FirebaseStorage
import com.lucas.whitelabelapp.BuildConfig
import com.lucas.whitelabelapp.domain.model.Product
import com.lucas.whitelabelapp.util.COLLECTION_PRODUCTS
import com.lucas.whitelabelapp.util.COLLECTION_ROOT
import kotlin.coroutines.suspendCoroutine


class FireBaseProjectDataSource(
    fireBaseFireStore:FirebaseFirestore,
    fireBaseStorage:FirebaseStorage
):ProductDataSource {

    private val documentReference = fireBaseFireStore.document("${COLLECTION_ROOT}/${BuildConfig.FIREBASE_FLAVOR_COLLECTION}/"    )

    private val storageReference = fireBaseStorage.reference

    override suspend fun getProducts(): List<Product> {

        return suspendCoroutine {continuation ->
            val productsReference = documentReference.collection(COLLECTION_PRODUCTS)
            productsReference.get().addOnSuccessListener { documents ->
                val products = mutableListOf<Product>()
                for (document in documents){
                    document.toObject(Product::class.java).run {
                        products.add(this)
                    }
                }
                continuation.resumeWith(Result.success(products))
            }

            productsReference.get().addOnFailureListener() {exception  ->
                continuation.resumeWith(Result.failure(exception))
            }
        }


    }

    override suspend fun createProduct(product: Product): Product {
        TODO("Not yet implemented")
    }

    override suspend fun upLoadProductImage(imageUri: Uri): String {
        TODO("Not yet implemented")
    }

}