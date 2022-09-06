package com.example.remed.features.data.repository


import com.example.remed.features.domain.datasource.ReMedDao
import com.example.remed.features.domain.model.ReMed
import com.example.remed.features.domain.repository.ReMedRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ReMedRepositoryImpl @Inject constructor(
    private val dao: ReMedDao
): ReMedRepository {
    override suspend fun insertReMed(remed: ReMed) {
        dao.insertReMed(remed = remed.domainToEntity())
    }

    override fun getRemeds(): Flow<List<ReMed>> {
        return dao.getAllReMeds().map { remeds ->
            remeds.map { it.toDomainModel() }
        }
    }


}