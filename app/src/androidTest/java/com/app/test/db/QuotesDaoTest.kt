package com.app.test.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.app.test.getOrAwaitValue
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule

class QuotesDaoTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var quoteDatabase: QuoteDatabase
    private lateinit var quoteDao: QuoteDao

    @Before
    fun setup() {
        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()
        quoteDao = quoteDatabase.quoteDao()
    }

    @After
    fun tearDown() {
        quoteDatabase.close()
    }

    @Test
    fun insert_quote_expected_successful_insertion_single_quote() = runTest {
        val quote = Quote(text = "This is a test quote", author = "Adil")
        quoteDao.insertQuote(quote)
        val result = quoteDao.getQuotes().getOrAwaitValue()
        assertEquals(1, result.size)
        assertEquals("This is a test quote", result[0].text)
    }

    @Test
    fun deleteQuote_expected_emptyQuotes() = runTest {
        val quote = Quote(text = "This is a test quote", author = "Adil")
        quoteDao.insertQuote(quote)
        quoteDao.deleteQuotes()
        val result = quoteDao.getQuotes().getOrAwaitValue()
        assertEquals(0, result.size)
    }

}