package com.example.pocketbotanist.ui.Owned

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import androidx.lifecycle.ViewModel
import com.example.pocketbotanist.data.Plant
import com.example.pocketbotanist.data.PlantRepository

class OwnedViewModel(private val plantRepository: PlantRepository) : ViewModel() {

    val plantListLiveData = plantRepository.getOwnedPlants()

    val plants = mutableListOf<Plant>()

}