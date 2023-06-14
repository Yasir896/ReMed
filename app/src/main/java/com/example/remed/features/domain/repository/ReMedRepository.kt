package com.example.remed.features.domain.repository


import com.example.remed.features.domain.model.ReMed
import kotlinx.coroutines.flow.Flow


interface ReMedRepository  {
    suspend fun insertReMed(remed: ReMed)
    fun getRemeds(): Flow<List<ReMed>>
    suspend fun deleteReMed(remed: ReMed)
}