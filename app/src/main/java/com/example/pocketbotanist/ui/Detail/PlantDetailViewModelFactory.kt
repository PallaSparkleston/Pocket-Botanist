package com.example.pocketbotanist.ui.Detail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pocketbotanist.data.PlantRepository

class PlantDetailViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PlantRepository::class.java)
            .newInstance(PlantRepository.getInstance(context))
    }
}
