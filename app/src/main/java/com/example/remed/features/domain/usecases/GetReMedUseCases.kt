package com.example.remed.features.domain.usecases

import com.example.remed.features.domain.repository.ReMedRepository

class GetReMedUseCases(private val repository: ReMedRepository) {
    suspend operator fun invoke() = repository.getRemeds()
}