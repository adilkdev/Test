package com.app.test.store

class ProductRepository(private val productAPI: ProductAPI) {

    suspend fun getProducts() : NetworkResult<List<Product>> {
        val response = productAPI.getProducts()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkResult.Success(responseBody)
            } else {
                NetworkResult.Error("Something went wrong")
            }
        }
        else
            NetworkResult.Error("Something went wrong")
    }

}