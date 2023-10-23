package com.example.finedust_app.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finedust_app.domain.GetMeasureInfoUseCase
import com.example.finedust_app.domain.models.MeasureInfoState
import com.example.finedust_app.ui.utils.FineDustUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception


class MainViewModel :ViewModel() {
    private val _uistate = MutableStateFlow<FineDustUiState<MeasureInfoState>>(FineDustUiState.Loading)
    val uiState = _uistate.asStateFlow()

    fun getMeasureInfo(latitude:Double,longitude:Double){
        viewModelScope.launch {
            try {
                val station =GetMeasureInfoUseCase().invoke(latitude,longitude)
                Log.d("hch", "getMeasureInfo: ${station}")
                _uistate.value =FineDustUiState.Success(station)

            }catch(exception: Exception) {
                _uistate.value=FineDustUiState.Error
            }
        }
    }
}