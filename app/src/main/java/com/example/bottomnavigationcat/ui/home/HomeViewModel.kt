package com.example.bottomnavigationcat.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {

    private val _navigateToDetails = MutableLiveData<Boolean>()

    val navigateToDetails : LiveData<Boolean>
        get() = _navigateToDetails


    fun userClicksOnButton() {
        _navigateToDetails.value = true
    }
    fun navigateToDetailsHandled() {
        _navigateToDetails.value = false
    }




//private val _navigateToDetails = SingleLiveEvent<Any>()
//
//    val navigateToDetails : LiveData<Any>
//        get() = _navigateToDetails
//
//
//    fun userClicksOnButton() {
//        _navigateToDetails.call()
//    }




//private val _navigateToDetails = MutableLiveData<Event<Boolean>>()
//
//    val navigateToDetails : LiveData<Event<Boolean>>
//        get() = _navigateToDetails
//
//
//    fun userClicksOnButton() {
//        _navigateToDetails.value = Event(true)  // Trigger the event by setting a new Event as a new value
//    }
}