package com.app.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.app.test.store.NetworkResult
import com.app.test.store.ProductRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var productRepository: ProductRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun get_products_expected_empty() = runTest {
        Mockito.`when`(productRepository.getProducts()).thenReturn(NetworkResult.Success(emptyList()))
        val vm = ViewModel(productRepository)
        vm.getProducts()
        mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
        val result = vm.products.getOrAwaitValue()
        assertEquals(0, result.data!!.size)
    }

    @Test
    fun get_products_expected_error() = runTest {
        Mockito.`when`(productRepository.getProducts()).thenReturn(NetworkResult.Error("Something went wrong"))
        val vm = ViewModel(productRepository)
        vm.getProducts()
        mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
        val result = vm.products.getOrAwaitValue()
        assertEquals(true, result is NetworkResult.Error)
    }

}