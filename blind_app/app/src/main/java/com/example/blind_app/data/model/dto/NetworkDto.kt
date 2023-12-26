package com.example.blind_app.data.model.dto

data class ListResponse(
    val success: Boolean,
    val code : Int,
    val meesage : String,
    val data : List<ContentDto>
)

data class ContentResponse(
    val success: Boolean,
    val code : Int,
    val meesage : String,
    val data : ContentDto?
)