package com.example.blind_app.data.model

import com.example.blind_app.data.model.dto.ContentDto
import com.example.blind_app.data.model.entity.ContentEntity
import com.example.blind_app.domain.model.Content
import java.util.Date

object ContentMapper {
    fun Content.toRequest() = ContentDto(
        id = id,
        title = title,
        content = content,
        category = category,
        likeCount = likeCount,
        commentCount = commentCount,
        viewCount = viewCount
    )
    fun ContentDto.toContent() = Content(
        id = id ?: -1,
        title = title,
        content = content,
        category = category,
        createdDate = createdDate?: Date(),
        likeCount = likeCount ?: 0,
        commentCount = commentCount?: 0,
        viewCount = viewCount?: 0,
    )
    fun Content.toEntity() = ContentEntity(
        id = id ?: -1,
        title = title,
        content = content,
        category = category,
        createdDate = createdDate?: Date(),
        likeCount = likeCount,
        commentCount = commentCount,
        viewCount = viewCount,

    )
    fun ContentEntity.toContent() =Content(
        id = id,
        title = title,
        content = content,
        category = category,
        likeCount = likeCount,
        commentCount = commentCount,
        viewCount = viewCount,
        createdDate = createdDate
    )
}