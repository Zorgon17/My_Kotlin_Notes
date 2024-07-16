package com.example.kotlin_notes.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.kotlin_notes.KotlinApplication
import com.example.kotlin_notes.ui.screens.AddScreenViewModel
import com.example.kotlin_notes.ui.screens.HomeScreenViewModel

object AppViewModelProvider {

    val Factory = viewModelFactory {
        initializer {
            AddScreenViewModel(
                kotlinNotesApplication().container.noteRepository
            )
        }
        initializer {
            HomeScreenViewModel(
                kotlinNotesApplication().container.noteRepository
            )
        }
    }
}

fun CreationExtras.kotlinNotesApplication(): KotlinApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as KotlinApplication)