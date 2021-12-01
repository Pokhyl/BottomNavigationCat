package com.example.bottomnavigationcat.ui.blank

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class BlankViewModel @Inject constructor() : ViewModel() {
  var liveData: MutableLiveData<String> = MutableLiveData()
   init {
       liveData.value = "Hello World"
   }
}