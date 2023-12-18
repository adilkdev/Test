package com.app.test.store

import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

class ProductRepositoryTest {

    @Mock
    lateinit var productAPI: ProductAPI

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `get products return empty list`() = runTest {
        Mockito.`when`(productAPI.getProducts()).thenReturn(Response.success(emptyList()))
        val repo = ProductRepository(productAPI)
        val result = repo.getProducts()
        assertEquals(true, result is NetworkResult.Success)
        assertEquals(0, result.data!!.size)
    }

    @Test
    fun `get products return product list`() = runTest {
        val productList = listOf(
            Product("", "", 1, "", 40.0, "Product 1"),
            Product("", "", 1, "", 50.0, "Product 2"),
        )
        Mockito.`when`(productAPI.getProducts()).thenReturn(Response.success(productList))
        val repo = ProductRepository(productAPI)
        val result = repo.getProducts()
        assertEquals(true, result is NetworkResult.Success)
        assertEquals(2, result.data!!.size)
        assertEquals("Product 1", result.data!![0].title)
    }

    @Test
    fun `get products expect error`() = runTest {
        Mockito.`when`(productAPI.getProducts()).thenReturn(Response.error(401, "Unauthorized".toResponseBody()))
        val repo = ProductRepository(productAPI)
        val result = repo.getProducts()
        assertEquals(true, result is NetworkResult.Error)
        assertEquals("Something went wrong", result.message)
    }
}