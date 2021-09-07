package com.example.pocketbotanist.ui.Catalog

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import androidx.lifecycle.ViewModel
import com.example.pocketbotanist.data.Plant
import com.example.pocketbotanist.data.PlantRepository

class CatalogViewModel(private val plantRepository: PlantRepository) : ViewModel() {

    val plantListLiveData = plantRepository.getPlants()

    val plants = mutableListOf<Plant>()

    init {
        try{
            SQLiteDatabase.openDatabase("/data/data/com.example.pocketbotanist/databases/plant-database", null, SQLiteDatabase.OPEN_READONLY)
        } catch (e: SQLiteException){
            val plant = Plant()
            plant.title = "Papyrus"
            plant.isOwned = false
            plant.indoor = "Indoor"
            plant.water = "High"
            plant.light = "High"
            plants += plant
            plantRepository.addPlant(plant)

            val plant1 = Plant()
            plant1.title = "Burro’s Tail"
            plant1.isOwned = false
            plant1.indoor = "Indoor"
            plant1.water = "Medium"
            plant1.light = "High"
            plants += plant1
            plantRepository.addPlant(plant1)

            val plant2 = Plant()
            plant2.title = "African Milk Tree"
            plant2.isOwned = false
            plant2.indoor = "Indoor"
            plant2.water = "Low"
            plant2.light = "High"
            plants += plant2
            plantRepository.addPlant(plant2)

            val plant3 = Plant()
            plant3.title = "Jade Plant"
            plant3.isOwned = false
            plant3.indoor = "Indoor"
            plant3.water = "Low"
            plant3.light = "Medium"
            plants += plant3
            plantRepository.addPlant(plant3)

            val plant4 = Plant()
            plant4.title = "African Violet"
            plant4.isOwned = false
            plant4.indoor = "Indoor"
            plant4.water = "Medium"
            plant4.light = "Medium"
            plants += plant4
            plantRepository.addPlant(plant4)

            val plant5 = Plant()
            plant5.title = "Boston Fern"
            plant5.isOwned = false
            plant5.indoor = "Indoor"
            plant5.water = "High"
            plant5.light = "Medium"
            plants += plant5
            plantRepository.addPlant(plant5)

            val plant6 = Plant()
            plant6.title = "Nerve Plant"
            plant6.isOwned = false
            plant6.indoor = "Indoor"
            plant6.water = "Medium"
            plant6.light = "Low"
            plants += plant6
            plantRepository.addPlant(plant6)

            val plant7 = Plant()
            plant7.title = "Lucky Bamboo"
            plant7.isOwned = false
            plant7.indoor = "Indoor"
            plant7.water = "High"
            plant7.light = "Low"
            plants += plant7
            plantRepository.addPlant(plant7)

            val plant8 = Plant()
            plant8.title = "ZZ Plant"
            plant8.isOwned = false
            plant8.indoor = "Indoor"
            plant8.water = "Low"
            plant8.light = "Low"
            plants += plant8
            plantRepository.addPlant(plant8)

            val plant9 = Plant()
            plant9.title = "Aloe Vera"
            plant9.isOwned = false
            plant9.indoor = "Outdoor"
            plant9.water = "Low"
            plant9.light = "High"
            plants += plant9
            plantRepository.addPlant(plant9)

            val plantq = Plant()
            plantq.title = "Daylily"
            plantq.isOwned = false
            plantq.indoor = "Outdoor"
            plantq.water = "Medium"
            plantq.light = "High"
            plants += plantq
            plantRepository.addPlant(plantq)

            val plantw = Plant()
            plantw.title = "Crinum Lilies"
            plantw.isOwned = false
            plantw.indoor = "Outdoor"
            plantw.water = "High"
            plantw.light = "High"
            plants += plantw
            plantRepository.addPlant(plantw)

            val plante = Plant()
            plante.title = "Lily of the Valley"
            plante.isOwned = false
            plante.indoor = "Outdoor"
            plante.water = "High"
            plante.light = "Medium"
            plants += plante
            plantRepository.addPlant(plante)

            val plantr = Plant()
            plantr.title = "Mint"
            plantr.isOwned = false
            plantr.indoor = "Outdoor"
            plantr.water = "Medium"
            plantr.light = "Medium"
            plants += plantr
            plantRepository.addPlant(plantr)

            val planta = Plant()
            planta.title = "Prickly Pear"
            planta.isOwned = false
            planta.indoor = "Outdoor"
            planta.water = "Low"
            planta.light = "Medium"
            plants += planta
            plantRepository.addPlant(planta)

            val plantd = Plant()
            plantd.title = "Sweet Woodruff"
            plantd.isOwned = false
            plantd.indoor = "Outdoor"
            plantd.water = "High"
            plantd.light = "Low"
            plants += plantd
            plantRepository.addPlant(plantd)

            val plantf = Plant()
            plantf.title = "Impatiens Cherry Splash"
            plantf.isOwned = false
            plantf.indoor = "Outdoor"
            plantf.water = "Medium"
            plantf.light = "Low"
            plants += plantf
            plantRepository.addPlant(plantf)

            val plantg = Plant()
            plantg.title = "Gasteria"
            plantg.isOwned = false
            plantg.indoor = "Outdoor"
            plantg.water = "Low"
            plantg.light = "Low"
            plants += plantg
            plantRepository.addPlant(plantg)
        }

    }

    fun addPlant(plant: Plant) {plantRepository.addPlant(plant)}
}