package com.jnetai.localpermit.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jnetai.localpermit.model.*

@Database(entities = [Permit::class, Requirement::class, Deadline::class], version = 1, exportSchema = false)
abstract class LocalPermitDatabase : RoomDatabase() {
    abstract fun dao(): LocalPermitDao
    companion object {
        @Volatile private var INSTANCE: LocalPermitDatabase? = null
        fun getInstance(context: Context): LocalPermitDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(context, LocalPermitDatabase::class.java, "localpermit.db")
                .fallbackToDestructiveMigration().build().also { INSTANCE = it }
        }
    }
}