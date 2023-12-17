package com.app.test.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuoteDao {

    @Insert
    suspend fun insertQuote(quote: Quote)

    @Update
    suspend fun updateQuote(quote: Quote)

    @Query("DELETE FROM quote")
    suspend fun deleteQuotes()

    @Query("DELETE FROM quote where id = :id")
    suspend fun deleteQuoteById(id: Int)

    @Query("SELECT * FROM quote")
    fun getQuotes(): LiveData<List<Quote>>

    @Query("SELECT * FROM quote WHERE id = :id")
    suspend fun getQuoteById(id: Int): Quote

}