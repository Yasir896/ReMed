package com.example.remed.features.domain.alarm

import com.example.remed.features.domain.model.Alarm

interface AlarmScheduler {
    fun schedule(alarm: Alarm)
    fun cancel(alarm: Alarm)
    fun snoozed(alarm: Alarm)
}