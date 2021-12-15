package com.example.bottomnavigationcat.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bottomnavigationcat.model.Book
import com.example.bottomnavigationcat.ui.blank.BlankRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

class BlankFragment2ViewModel @Inject constructor(var repository: BlankRepository)  : ViewModel() {

    var bookLiveData:MutableLiveData<Book> = MutableLiveData()
    private val _navigateToBlankFragment = MutableLiveData<Boolean>()

    val navigateToBlankFragment : LiveData<Boolean>
        get() = _navigateToBlankFragment


    fun userClicksOnButton() {
        _navigateToBlankFragment.value = true
    }
    fun navigateToDetailsHandled() {
        _navigateToBlankFragment.value = false
    }
    private val handler = CoroutineExceptionHandler { _, exception ->
        Log.e("TAG", "CoroutineExceptionHandler got", exception)
    }

    private val scope = viewModelScope + handler + Dispatchers.Default
fun setBook(title: String, author: String, description: String, published: Int) {
    println("$title $author $description $published")
    bookLiveData.value = Book(title ,
                author,
                description,
                published)
}
    fun saveBookToDatabase( ) {
    println(bookLiveData.value)
        scope.launch {
            bookLiveData.value?.let { repository.addNewBook(it) }

        }
        userClicksOnButton()
    }
    fun updateBookToDatabase( id:Int) {
        println(bookLiveData.value)
        scope.launch {
            bookLiveData.value?.let {
                it.id = id
                repository.updateBook(it) }

        }
        userClicksOnButton()
    }
}