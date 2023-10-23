package com.example.finedust_app.ui.utils

//로딩 상태와 에러 상태는 데이터를 가질 필요가 없으므로 생성자가 필요 없으므로 object로 선언해 주었다.
sealed class FineDustUiState<out T>(val _data : T?) {
    object Loading : FineDustUiState<Nothing>(_data =null)
    object Error : FineDustUiState<Nothing>(_data = null)
    data class Success<out T>(val data: T) : FineDustUiState<T>(_data = data)
}

