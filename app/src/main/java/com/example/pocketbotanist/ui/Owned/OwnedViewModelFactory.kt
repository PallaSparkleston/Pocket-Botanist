package com.example.pocketbotanist.ui.Owned

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pocketbotanist.data.PlantRepository


internal class OwnedViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PlantRepository::class.java)
            .newInstance(PlantRepository.getInstance(context))
    }
}
