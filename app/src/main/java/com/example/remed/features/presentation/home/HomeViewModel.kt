package com.example.remed.features.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remed.features.domain.model.ReMed
import com.example.remed.features.domain.usecases.ReMedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: ReMedUseCase) : ViewModel() {

    private val _state = mutableStateOf(ReMedState())
    val state: State<ReMedState> = _state

    fun getAllReMeds() {
        viewModelScope.launch {
            useCase.getReMedUseCases().collect() { remeds ->
                _state.value = state.value.copy(
                    remeds = remeds
                )
            }
        }
    }

}