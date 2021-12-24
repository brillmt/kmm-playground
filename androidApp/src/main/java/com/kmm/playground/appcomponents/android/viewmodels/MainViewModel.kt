package com.kmm.playground.appcomponents.android.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmm.playground.appcomponents.data.repository.UserRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: UserRepository): ViewModel() {

    private val _initString = MutableLiveData<String>()
    val initString: LiveData<String> = _initString

    fun start() {
        viewModelScope.launch {
            val user = repository.getLoggedInUser()
            _initString.value = "Hello ${user.firstName} ${user.lastName}!!!"
        }
    }
}