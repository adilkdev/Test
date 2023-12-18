package com.app.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.test.store.NetworkResult
import com.app.test.store.Product
import com.app.test.store.ProductRepository
import kotlinx.coroutines.launch

class ViewModel(private val repository: ProductRepository): ViewModel() {

    private val _products = MutableLiveData<NetworkResult<List<Product>>>()
    val products: LiveData<NetworkResult<List<Product>>>
        get() = _products

    fun getProducts() {
        viewModelScope.launch {
            val result = repository.getProducts()
            _products.postValue(result)
        }
    }

}