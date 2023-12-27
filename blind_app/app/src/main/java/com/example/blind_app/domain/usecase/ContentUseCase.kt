package com.example.blind_app.domain.usecase

import androidx.room.Insert
import com.example.blind_app.domain.model.Content
import com.example.blind_app.domain.repository.ContentRepositiry
import javax.inject.Inject

class ContentUseCase @Inject constructor(
    private val contentRepositiry: ContentRepositiry
){
    suspend fun save(item: Content) =contentRepositiry.save(item)

    fun loadList() = contentRepositiry.loadList()

}