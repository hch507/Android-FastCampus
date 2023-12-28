package com.example.compose_todo.model

data class TodoData(
    val key : Int,
    val text : String,
    val done : Boolean = false
)
