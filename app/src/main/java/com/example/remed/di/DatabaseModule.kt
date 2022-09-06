package com.example.remed.di

import android.content.Context
import com.example.remed.features.domain.datasource.ReMedDao
import com.example.remed.storage.ReMedDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideDb(@ApplicationContext context: Context) = ReMedDatabase.create(context)

    @Provides
    fun provideReMedDao(database: ReMedDatabase): ReMedDao= database.reMedDao()

}