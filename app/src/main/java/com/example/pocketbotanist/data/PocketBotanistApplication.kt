package com.example.pocketbotanist.data

import android.app.Application

class PocketBotanistApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        PlantRepository.initialize(this)
    }
}