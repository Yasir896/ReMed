package com.example.remed.features.presentation.create_new

import android.text.TextUtils
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remed.features.domain.model.ReMed
import com.example.remed.features.domain.usecases.ReMedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateNewReMedViewModel @Inject constructor(private val useCase: ReMedUseCase): ViewModel() {

    private val _nameText = mutableStateOf("")
    val nameText: State<String> = _nameText

    private val _instructionsText = mutableStateOf("")
    val instructionsText: State<String> = _instructionsText

    private val _startDate = mutableStateOf("")
    val startDate: State<String> = _startDate

    private val _endDate = mutableStateOf("")
    val endDate: State<String> = _endDate

    private val _time = mutableStateOf("")
    val time: State<String> = _time


    fun setNameText(name: String) {
        _nameText.value = name
    }

    fun setInstructionsText(instructions: String) {
        _instructionsText.value = instructions
    }

    fun setStartDate(start: String) {
        _startDate.value = start
    }

    fun setEndDate(end: String) {
        _endDate.value = end
    }

    fun setTime(time: String) {
        _time.value = time
    }
    fun newReMed() {
        if (TextUtils.isEmpty(nameText.value)) {
            Log.d("REMEDVIEWMODEL::", "Title can not be empty.")
        } else if (TextUtils.isEmpty(instructionsText.value)) {
            Log.d("REMEDVIEWMODEL::", "Instructions can not be empty.")
        } else if (TextUtils.isEmpty(startDate.value)) {
            Log.d("REMEDVIEWMODEL::", "Start date can not be empty.")
        } else if (TextUtils.isEmpty(endDate.value)) {
            Log.d("REMEDVIEWMODEL::", "End date can not be empty.")
        } else if (TextUtils.isEmpty(time.value)) {
            Log.d("REMEDVIEWMODEL::", "Time can not be empty.")
        } else {
            saveToDatabase(ReMed(
                title = nameText.value,
                instructions = instructionsText.value,
                startDate = startDate.value,
                endDate = endDate.value,
                time = time.value,
                completed = false,
                snoozed = false,
            ))
        }
    }

    private fun saveToDatabase(remed: ReMed) {
        viewModelScope.launch {
            useCase.insertReMedUseCase.invoke(remed)
        }
    }
}