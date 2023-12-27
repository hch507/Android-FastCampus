package com.example.blind_app.data.di

import com.example.blind_app.data.repositoryImpl.ContentRepositoryImpl
import com.example.blind_app.data.source.local.dao.ContentDao
import com.example.blind_app.data.source.remote.api.ContentService
import com.example.blind_app.domain.repository.ContentRepositiry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositroyModule {

    @Provides
    @ViewModelScoped
    fun proviedContentRepository(contentService:ContentService, contentDao: ContentDao):ContentRepositiry = ContentRepositoryImpl(contentService, contentDao)
}