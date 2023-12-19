package com.app.test.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@TestInstallIn(components = [SingletonComponent::class], replaces = [DBModule::class])
@Module
class TestDBModule {

    @Singleton
    @Provides
    fun provideTestDb(@ApplicationContext context: Context) : QuoteDatabase {
        return Room.inMemoryDatabaseBuilder(
            context,
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()
    }

}