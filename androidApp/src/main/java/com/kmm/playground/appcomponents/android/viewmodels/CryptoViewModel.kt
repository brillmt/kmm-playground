package com.kmm.playground.appcomponents.android.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmm.playground.appcomponents.data.model.CryptoCoin
import com.kmm.playground.appcomponents.data.repository.CryptoRepository
import kotlinx.coroutines.launch

class CryptoViewModel(private val repository: CryptoRepository) : ViewModel() {

    private val _data = MutableLiveData<List<CryptoCoin>>()
    val data: LiveData<List<CryptoCoin>> = _data

    fun start() {
        repository.getCoins().collectCommon(viewModelScope) {
            _data.value = it.data
        }
    }
}