package com.example.remed.features.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.remed.features.domain.model.ReMed


@Entity
class ReMedEntity(
    @PrimaryKey
    val reMedId: Int,
    val title: String,
    val description: String,
    val completed: Boolean,
    val snoozed: Boolean,
    ) {
    fun toDomainModel() = ReMed(id = reMedId, title = title, description = description, completed = completed, snoozed = snoozed)
}
