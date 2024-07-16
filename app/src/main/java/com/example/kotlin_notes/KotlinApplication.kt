package com.example.kotlin_notes

import android.app.Application
import com.example.kotlin_notes.database.repository.AppContainer
import com.example.kotlin_notes.database.repository.AppDataContainer

class KotlinApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}