package com.example.remed.features.presentation.create_new

import androidx.lifecycle.ViewModel
import com.example.remed.features.domain.usecases.ReMedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateNewReMedViewModel @Inject constructor(private val useCase: ReMedUseCase): ViewModel() {

}