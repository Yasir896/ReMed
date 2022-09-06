package com.example.remed.features.data.db

import com.example.remed.features.domain.Resource
import com.example.remed.features.domain.datasource.ReMedDao
import com.example.remed.features.domain.model.ReMed
import kotlinx.coroutines.flow.map



/*
fun ReMedDao.fetchAllReMeds() =
getAllReMeds().map { it?.map { it.toDomainModel() } }.map {
    it.let {
            Resource.success(it)
    } ?: error("")
}

suspend fun ReMedDao.insertNewReMed(reminder: ReMed) {

    reminder.let {
        reminder.id.let {
            insertReMed(
                ReMedEntity(
                    reMedId = reminder.id,
                    title = reminder.title,
                    description = reminder.description,
                    completed = reminder.completed,
                    snoozed = reminder.snoozed
                )
            )
        }
    }
}*/
