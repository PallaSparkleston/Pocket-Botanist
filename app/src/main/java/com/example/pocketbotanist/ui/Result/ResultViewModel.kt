package com.example.pocketbotanist.ui.Result

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import androidx.lifecycle.ViewModel
import com.example.pocketbotanist.data.Plant
import com.example.pocketbotanist.data.PlantRepository

class ResultViewModel(private val plantRepository: PlantRepository) : ViewModel() {


    val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)?: return
    var indo = sharedPref.getString("1", "Indoor")
    var lig = sharedPref.getString("2", "High")
    var wat = sharedPref.getString("3", "High")

    val plantListLiveData = plantRepository.getRequestedPlants(indo, lig, wat)

    val plants = mutableListOf<Plant>()

}