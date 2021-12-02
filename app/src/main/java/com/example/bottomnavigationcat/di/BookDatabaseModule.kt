package com.example.bottomnavigationcat.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bottomnavigationcat.db.BookDao
import com.example.bottomnavigationcat.db.BookDatabase
import dagger.Module
import dagger.Provides

@Module
class BookDatabaseModule {
    @Provides
    fun createBookDatabase(application: Application): BookDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            BookDatabase::class.java,
        "books"
        )
            .build()
    }
    @Provides
    fun createBookDao(bookDatabase: BookDatabase):BookDao{
        return bookDatabase.getBookDao()
    }
}