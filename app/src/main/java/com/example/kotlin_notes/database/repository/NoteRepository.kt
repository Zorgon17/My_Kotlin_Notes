package com.example.kotlin_notes.database.repository

import com.example.kotlin_notes.database.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun insertNotes(entity: Note)

    suspend fun updateNotes(entity: Note)

    suspend fun deleteNotes(entity: Note)

    fun getNotes(id: Int): Flow<Note?>
}