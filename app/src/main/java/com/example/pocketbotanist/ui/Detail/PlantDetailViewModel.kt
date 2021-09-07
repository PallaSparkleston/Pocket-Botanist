package com.example.pocketbotanist.ui.Detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.pocketbotanist.data.Plant
import com.example.pocketbotanist.data.PlantRepository
import java.util.*

class PlantDetailViewModel(private val plantRepository: PlantRepository): ViewModel() {

    private val plantIdLiveData = MutableLiveData<UUID>()

    var plantLiveData: LiveData<Plant?> =
    Transformations.switchMap(plantIdLiveData) { plantId ->
    plantRepository.getPlant(plantId)
    }

    fun loadPlant(plantId: UUID) {
        plantIdLiveData.value = plantId
    }
}
