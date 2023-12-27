package com.example.blind_app.data.repositoryImpl

import com.example.blind_app.data.model.ContentMapper.toContent
import com.example.blind_app.data.model.ContentMapper.toEntity
import com.example.blind_app.data.model.ContentMapper.toRequest
import com.example.blind_app.data.source.local.dao.ContentDao
import com.example.blind_app.data.source.remote.api.ContentService
import com.example.blind_app.domain.model.Content
import com.example.blind_app.domain.repository.ContentRepositiry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val contentService: ContentService,
    private val contentDao: ContentDao
) : ContentRepositiry {
    override fun loadList(): Flow<List<Content>> {
        return flow {
            contentDao.selectAll().collect{list ->
                emit(list.map{it.toContent()})
            }
            emit(
                try {
                    contentService.getList().data.map { it.toContent() }
                } catch (e: IOException) {
                    emptyList()
                }
            )
        }
    }

    override suspend fun save(item: Content): Boolean {
        return try {
            contentService.saveItem(item.toRequest())
            contentDao.insert(item.toEntity())
            true
        } catch (e: IOException) {
            false
        }
    }

    override suspend fun update(item: Content): Boolean {
        return try {
            contentService.updateItem(item.toRequest())
            contentDao.insert(item.toEntity())
            true
        } catch (e: IOException) {
            false
        }
    }

}