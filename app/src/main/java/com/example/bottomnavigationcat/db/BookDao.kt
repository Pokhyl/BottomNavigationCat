package com.example.bottomnavigationcat.db

import androidx.room.*
import com.example.bottomnavigationcat.model.Book

@Dao
interface BookDao {

    @Query("SELECT * FROM book")
    suspend fun getAllBooks () : List<Book>

    @Query("SELECT * FROM book WHERE id = :id")
    suspend fun getBookByID(id : Int) : Book

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewBook(book: Book)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllBook(listBook: List<Book>)

    @Update
    suspend fun updateBook(book : Book)

    @Delete
    suspend fun deleteBook (book: Book)

    @Query("DELETE FROM book")
    suspend fun deleteAllBook()


}