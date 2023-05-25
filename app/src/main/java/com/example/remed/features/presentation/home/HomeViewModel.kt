package com.example.remed.features.presentation.home

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remed.features.domain.usecases.ReMedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: ReMedUseCase) : ViewModel() {

    private val _state = mutableStateOf(ReMedState())
    val state: State<ReMedState> = _state

    init {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            getAllReMeds()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getAllReMeds() {
        viewModelScope.launch {
            useCase.getReMedUseCases().collect() { remeds ->
                _state.value = state.value.copy(
                    remeds = remeds
                )

                if (state.value != null) {
                    getCurrentReminder()
                }
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentReminder() {
        var oldDifference: Int = 0
        val currentDate = getTodayDate()
        val currentTime = getCurrentTime()
        if (state.value.remeds.isNotEmpty()) {
            state.value.remeds.forEach { reminder ->
                if (currentDate >= getDateFromString(reminder.startDate)
                    && currentDate <= getDateFromString(reminder.endDate)) {
                        val reminderTime = getTimeFromString(currentDate.toString() + " ${reminder.time}")
                        val diff = reminderTime.compareTo(currentTime)
                    if (oldDifference == 0) {
                        state.value.currentRemed = reminder
                        oldDifference = diff
                    } else if (diff < oldDifference) {
                        state.value.currentRemed = reminder
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getTimeFromString(time: String): LocalDateTime {
        Log.d("TimeStamp to Parse:", time)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        return LocalDateTime.parse(time, formatter)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getDateFromString(date: String): LocalDate {
        val formatter = DateTimeFormatter.ofPattern("dd/M/yyyy")
        return LocalDate.parse(date, formatter)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getTodayDate(): LocalDate {
        return LocalDate.now()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun  getCurrentTime(): LocalDateTime {
        return LocalDateTime.now()
    }
}

