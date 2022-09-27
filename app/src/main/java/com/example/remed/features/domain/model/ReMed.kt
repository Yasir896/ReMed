package com.example.remed.features.domain.model

import com.example.remed.features.data.db.ReMedEntity

data class ReMed(
    val id: Int? = null,
    val title: String,
    val instructions: String,
    val startDate: String,
    val endDate: String,
    val time: String,
    val completed: Boolean,
    val snoozed: Boolean,
) {
    fun domainToEntity() = ReMedEntity(
        reMedId = id,
        title = title,
        instructions = instructions,
        startDate = startDate,
        endDate = endDate,
        time = time,
        completed = completed,
        snoozed = snoozed,
    )

}