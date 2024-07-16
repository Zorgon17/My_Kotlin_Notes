package com.example.kotlin_notes.database.repository

import com.example.kotlin_notes.database.Note
import com.example.kotlin_notes.database.NoteDao
import kotlinx.coroutines.flow.Flow

class OfflineNoteRepository(private val noteDao: NoteDao) : NoteRepository {
    override suspend fun insertNote(entity: Note) = noteDao.insert(entity)

    override suspend fun updateNote(entity: Note) = noteDao.update(entity)

    override suspend fun deleteNote(entity: Note) = noteDao.delete(entity)

    override fun getNote(id: Int): Flow<Note?> = noteDao.getNote(id)

    override fun getAllNotes(): Flow<List<Note>> = noteDao.getAllNotes()
}