package com.example.remed.features.domain.usecases

import com.example.remed.features.domain.model.ReMed
import com.example.remed.features.domain.repository.ReMedRepository

class InsertReMedUseCase(private val repository: ReMedRepository) {
    suspend operator fun invoke(reMed: ReMed) = repository.insertReMed(reMed)
}