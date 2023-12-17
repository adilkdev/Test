package com.app.test

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class DetailTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    /**
     * we can avoid this setup and tearDown in every class by creating a rule for the same.
     */
    /*
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }*/

    @Test
    fun get_message() {
        val detail = Detail()
        /** @runBlocking will be delayed */
        /*
        runBlocking {
            detail.getMessage()
        }
        */

        /** @runTest will skip the delays and perform other optimizations */
        runTest {
            val result = detail.getMessage()
            Assert.assertEquals("Hello World", result)
        }
    }

    @Test
    fun get_message_on_main() {
        val detail = Detail()
        runTest {
            val result = detail.getMessageOnMain()
            Assert.assertEquals("Hello World", result)
        }
    }

}