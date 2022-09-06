package com.example.remed.di

import com.example.remed.features.data.repository.ReMedRepositoryImpl
import com.example.remed.features.domain.datasource.ReMedDao
import com.example.remed.features.domain.repository.ReMedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideReMedRepository(
        reMedDao: ReMedDao
    ): ReMedRepository = ReMedRepositoryImpl(reMedDao)
}