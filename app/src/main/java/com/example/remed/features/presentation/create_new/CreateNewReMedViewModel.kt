package com.example.remed.features.presentation.create_new

import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remed.features.domain.model.ReMed
import com.example.remed.features.domain.usecases.ReMedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateNewReMedViewModel @Inject constructor(private val useCase: ReMedUseCase): ViewModel() {
    
    fun newReMed(name: String, instructions: String, start: String, end: String, time: String) {
        if (TextUtils.isEmpty(name)) {
            Log.d("REMEDVIEWMODEL::", "Title can not be empty.")
        } else if (TextUtils.isEmpty(instructions)) {
            Log.d("REMEDVIEWMODEL::", "Instructions can not be empty.")
        } else if (TextUtils.isEmpty(start)) {
            Log.d("REMEDVIEWMODEL::", "Start date can not be empty.")
        } else if (TextUtils.isEmpty(end)) {
            Log.d("REMEDVIEWMODEL::", "End date can not be empty.")
        } else if (TextUtils.isEmpty(time)) {
            Log.d("REMEDVIEWMODEL::", "Time can not be empty.")
        } else {
            saveToDatabase(ReMed(
                title = name,
                instructions = instructions,
                startDate = start,
                endDate = end,
                time = time,
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