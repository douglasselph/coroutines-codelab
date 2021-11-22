package com.dugsolutions.coroutinesmvc.titleDisplay.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TitleUIElements : ViewModel() {

    private val _taps: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }

    val taps: LiveData<Int>
        get() = _taps

}