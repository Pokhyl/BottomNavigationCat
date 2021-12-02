package com.example.bottomnavigationcat.ui.blank

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.bottomnavigationcat.db.BookDao
import com.example.bottomnavigationcat.db.BookDatabase
import com.example.bottomnavigationcat.model.Book
import javax.inject.Inject

class BlankRepository @Inject constructor(var bookDao: BookDao) {

    var liveData: MutableLiveData<String> = MutableLiveData()
    init {
        liveData.value = "Hello World"

    }

    suspend fun getAllBooks () : List<Book>{
        return bookDao.getAllBooks()
    }


    suspend fun getBookByID(id : Int) : Book{
        return bookDao.getBookByID(id)
    }


    suspend fun addNewBook(book: Book){
        bookDao.addNewBook(book)
    }


    suspend fun addAllBook(listBook: List<Book>){
        bookDao.addAllBook(listBook)
    }


    suspend fun updateBook(book : Book){
        bookDao.updateBook(book)
    }


    suspend fun deleteBook (book: Book){
        bookDao.deleteBook(book)
    }


    suspend fun deleteAllBook(){
        bookDao.deleteAllBook()
    }
}