package com.app.test.store

import retrofit2.Response
import retrofit2.http.GET

interface ProductAPI {

    @GET("/products")
    suspend fun getProducts(): Response<List<Product>>

}