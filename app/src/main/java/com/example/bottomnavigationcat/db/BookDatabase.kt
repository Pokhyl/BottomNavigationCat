package com.example.bottomnavigationcat.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bottomnavigationcat.model.Book

@Database(entities = [Book::class], version = 1)

abstract class BookDatabase: RoomDatabase() {
    abstract fun getBookDao():BookDao
}