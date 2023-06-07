package com.example.remed.di

import com.example.remed.features.domain.repository.ReMedRepository
import com.example.remed.features.domain.usecases.DeleteUseCase
import com.example.remed.features.domain.usecases.GetReMedUseCases
import com.example.remed.features.domain.usecases.InsertReMedUseCase
import com.example.remed.features.domain.usecases.ReMedUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    fun provideReMedUseCase(repository: ReMedRepository) = ReMedUseCase(
        getReMedUseCases = GetReMedUseCases(repository),
        insertReMedUseCase = InsertReMedUseCase(repository),
        deleteUseCase = DeleteUseCase(repository)
    )
}