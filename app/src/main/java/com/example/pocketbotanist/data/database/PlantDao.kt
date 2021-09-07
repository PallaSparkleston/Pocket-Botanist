package com.example.pocketbotanist.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.pocketbotanist.data.Plant
import java.util.*

@Dao
interface PlantDao {

    @Query("SELECT * FROM plant")
    fun getPlants(): LiveData<List<Plant>>

    @Query("SELECT * FROM plant WHERE id=(:id)")
    fun getPlant(id: UUID): LiveData<Plant?>

    @Query("SELECT * FROM plant WHERE isOwned=1")
    fun getOwnedPlants(): LiveData<List<Plant>>

    @Query("SELECT * FROM plant WHERE indoor=:indoor AND water=:water AND light=:light")
    fun getRequestedPlant(indoor:String?, water:String?, light:String?): LiveData<List<Plant>>

    @Update
    fun updateOwned(plant: Plant)

    @Insert
    fun addPlant(plant: Plant)
}