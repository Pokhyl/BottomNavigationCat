package com.example.bottomnavigationcat.ui.blank

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class BlankRepository @Inject constructor() {
    var liveData: MutableLiveData<String> = MutableLiveData()
    init {
        liveData.value = "Hello World"
    }
}