package com.example.kotlin_notes.database.repository

import com.example.kotlin_notes.database.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun insertNote(entity: Note)

    suspend fun updateNote(entity: Note)

    suspend fun deleteNote(entity: Note)

    fun getNote(id: Int): Flow<Note?>

    fun getAllNotes(): Flow<List<Note>>
}