package com.example.kotlin_notes.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Entity")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    val noteId: Int = 0,
    val noteTitle: String,
    val noteBody:  String
)
