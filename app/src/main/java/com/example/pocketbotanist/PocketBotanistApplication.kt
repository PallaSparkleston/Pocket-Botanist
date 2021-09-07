package com.example.pocketbotanist

import android.app.Application
import android.util.Log

class PocketBotanistApplication: Application() {
    private val logTag = "448.PocketBotanistApp"

    override fun onCreate() {
        super.onCreate()
        Log.d(logTag, "onCreate() called")
    }
}
