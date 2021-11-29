package com.example.bottomnavigationcat.ui.blank

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlankViewModel : ViewModel() {
  var liveData: MutableLiveData<String> = MutableLiveData()
   init {
       liveData.value = "Hallo World"
   }
}