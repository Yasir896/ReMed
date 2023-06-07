package com.example.remed.features.domain.usecases

import com.example.remed.features.domain.model.ReMed
import com.example.remed.features.domain.repository.ReMedRepository

class DeleteUseCase(private val repository: ReMedRepository) {
    suspend operator fun invoke(remed: ReMed) = repository.deleteReMed(remed)
}