package com.example.remed.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.remed.features.data.db.ReMedEntity
import com.example.remed.features.domain.datasource.ReMedDao


@Database(
    entities = [ReMedEntity::class],
    version = ReMedDatabase.VERSION,
    exportSchema = false
)


abstract class ReMedDatabase: RoomDatabase() {

    abstract fun reMedDao(): ReMedDao

    companion object {
        internal const val VERSION = 1
        private const val NAME = "remed_db"

        fun create(applicationContext: Context): ReMedDatabase {
                return Room.databaseBuilder(
                    applicationContext,
                    ReMedDatabase::class.java,
                    NAME
                ).build()
        }
    }
}