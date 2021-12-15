package com.example.bottomnavigationcat.ui.blank

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bottomnavigationcat.model.Book
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

class BlankViewModel @Inject constructor(var repository: BlankRepository) : ViewModel() {
  var liveData: MutableLiveData<List<Book>> = MutableLiveData()
   init {

   }
private val handler = CoroutineExceptionHandler { _, exception ->
    Log.e("TAG", "CoroutineExceptionHandler got", exception)
}

    private val scope = viewModelScope + handler + Dispatchers.IO

    fun loadBookListFromDatabase() {

        scope.launch {
            liveData.postValue(repository.getAllBooks())

        }
    }
    fun delete(book: Book) {

        scope.launch {
            repository.deleteBook(book)

        }
    }
}