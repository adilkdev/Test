package com.app.test

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.app.test.store.NetworkResult
import com.app.test.store.ProductRepository

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: ViewModel
    lateinit var productRepository: ProductRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productRepository = (application as TestApplication).productRepository

        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                return ViewModel(productRepository) as T
            }
        })[ViewModel::class.java]

        setContentView(R.layout.acitvity_main)

        viewModel.getProducts()

        viewModel.products.observe(this) {
            when(it) {
                is NetworkResult.Success -> {
                    Log.d("testLog", it.data.toString())
                }
                is NetworkResult.Error -> {}
                is NetworkResult.Loading -> {}
            }
        }
    }
}