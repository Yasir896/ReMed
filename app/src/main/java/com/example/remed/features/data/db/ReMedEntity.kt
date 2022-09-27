package com.example.remed.features.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.remed.features.domain.model.ReMed


@Entity
class ReMedEntity(
    @PrimaryKey(autoGenerate = true)
    val reMedId: Int? = null,
    val title: String,
    val instructions: String,
    val startDate: String,
    val endDate: String,
    val time: String,
    val completed: Boolean,
    val snoozed: Boolean,
    ) {
    fun toDomainModel() = ReMed(
        id = reMedId,
        title = title,
        instructions = instructions,
        startDate = startDate,
        endDate = endDate,
        time = time,
        completed = completed,
        snoozed = snoozed)

}
