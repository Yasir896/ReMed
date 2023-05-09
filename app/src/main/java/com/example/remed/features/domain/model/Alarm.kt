package com.example.remed.features.domain.model

import java.time.LocalDateTime

data class Alarm(
    val alarmTime: LocalDateTime,
    val message: String
)