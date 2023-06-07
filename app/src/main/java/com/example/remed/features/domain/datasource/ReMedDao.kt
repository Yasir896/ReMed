package com.example.remed.features.domain.datasource

import androidx.room.*
import com.example.remed.features.data.db.ReMedEntity
import com.example.remed.features.domain.model.ReMed
import kotlinx.coroutines.flow.Flow

@Dao
interface ReMedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReMed(remed: ReMedEntity)

    @Query("SELECT * FROM ReMedEntity" )
    fun getAllReMeds(): Flow<List<ReMedEntity>>

    @Delete
    suspend fun deleteReMed(remed: ReMedEntity)

}