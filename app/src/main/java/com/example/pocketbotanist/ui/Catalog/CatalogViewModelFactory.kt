package com.example.pocketbotanist.ui.Catalog

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pocketbotanist.data.PlantRepository


internal class CatalogViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PlantRepository::class.java)
            .newInstance(PlantRepository.getInstance(context))
    }
}
