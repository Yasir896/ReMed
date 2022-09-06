package com.example.remed.features.domain.model

import com.example.remed.features.data.db.ReMedEntity

data class ReMed(
    val id: Int,
    val title: String,
    val description: String,
    val completed: Boolean,
    val snoozed: Boolean
) {
    fun domainToEntity() = ReMedEntity(
        reMedId = id,
        title = title,
        description = description,
        completed = completed,
        snoozed = snoozed
    )
}
