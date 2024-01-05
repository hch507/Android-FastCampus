package com.example.compose_todo.model

import androidx.lifecycle.MutableLiveData

data class TodoData(
    val key: Int,
    val text: String,
    val done: Boolean = false
)
