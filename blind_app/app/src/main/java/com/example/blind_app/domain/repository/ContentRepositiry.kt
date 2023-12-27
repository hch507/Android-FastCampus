package com.example.blind_app.domain.repository

import com.example.blind_app.domain.model.Content
import kotlinx.coroutines.flow.Flow


interface ContentRepositiry {

    fun loadList () : Flow<List<Content>>
    suspend fun save(item : Content) : Boolean
    suspend fun update(item: Content) : Boolean
}