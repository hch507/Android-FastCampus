package com.example.android_delivery_app.screen.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val stateBundle : Bundle?= null

    open fun fetchData() : Job = viewModelScope.launch {  }

    open fun storeState(stateBundle: Bundle){
        this.stateBundle
    }
}