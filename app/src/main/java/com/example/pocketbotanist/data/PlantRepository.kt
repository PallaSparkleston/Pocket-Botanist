package com.example.pocketbotanist.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pocketbotanist.data.database.PlantDao
import com.example.pocketbotanist.data.database.PlantDatabase
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors

private const val DATABASE_NAME = "plant-database"

class PlantRepository (private val plantDao: PlantDao)
{

    private val executor = Executors.newSingleThreadExecutor()

    fun getPlants(): LiveData<List<Plant>> = plantDao.getPlants()

    fun getOwnedPlants(): LiveData<List<Plant>> = plantDao.getOwnedPlants()

    fun getRequestedPlants(indoor: String?, light: String?, water: String?): LiveData<List<Plant>> = plantDao.getRequestedPlant(indoor, light, water)

    fun getPlant(id: UUID): LiveData<Plant?> = plantDao.getPlant(id)

    fun addPlant(plant: Plant) {
        executor.execute {
            plantDao.addPlant(plant)
        }
    }

    fun updateOwned(plant: Plant) {
        executor.execute {
            plantDao.updateOwned(plant)
        }
    }

    companion object {
        private var INSTANCE: PlantRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                if (INSTANCE == null) {
                    val database = PlantDatabase.getInstance(context)
                    INSTANCE = PlantRepository(database.plantDao())
                }

            }
        }

        fun get(): PlantRepository {
            return INSTANCE ?:
            throw IllegalStateException("PlantRepository must be initialized")
        }

        fun getInstance(context: Context): PlantRepository? {
            return INSTANCE
        }
    }
}