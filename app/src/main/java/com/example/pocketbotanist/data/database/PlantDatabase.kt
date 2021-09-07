package com.example.pocketbotanist.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pocketbotanist.data.Plant
import com.example.pocketbotanist.data.PlantTypeConverters

private const val DATABASE_NAME = "plant-database"

@Database(entities = [ Plant::class ], version=1)
@TypeConverters(PlantTypeConverters::class)
abstract class PlantDatabase : RoomDatabase() {

    companion object {
        private var instance: PlantDatabase? = null


        fun getInstance(context: Context): PlantDatabase {
            return instance ?: let {
                instance ?: Room.databaseBuilder(
                    context,
                    PlantDatabase::class.java,
                    DATABASE_NAME
                )
                    .build()
            }
        }
    }

    abstract fun plantDao(): PlantDao
}