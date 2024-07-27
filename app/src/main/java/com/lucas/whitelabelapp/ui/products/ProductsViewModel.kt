package com.lucas.whitelabelapp.ui.products

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.whitelabelapp.config.Config
import com.lucas.whitelabelapp.domain.model.Product
import com.lucas.whitelabelapp.domain.useCase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase:GetProductsUseCase,
    config: Config
):ViewModel() {

    private val _productsData = MutableLiveData<List<Product>>()
    val producsData: LiveData<List<Product>> = _productsData

    private val _addButtonVisibilityData = MutableLiveData(config.addButtonVisibility)
    val addButtonVisibilityData: LiveData<Int> = _addButtonVisibilityData

    fun getProducts() = viewModelScope.launch {
        try {
            val products = getProductsUseCase()
            _productsData.value = products
        }catch (e:Exception){
            Log.d("Products owner View model", e.toString())
        }
    }
}