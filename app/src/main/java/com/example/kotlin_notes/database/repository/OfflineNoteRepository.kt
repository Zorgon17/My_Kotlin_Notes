package com.example.kotlin_notes.database.repository

import com.example.kotlin_notes.database.Note
import com.example.kotlin_notes.database.NoteDao
import kotlinx.coroutines.flow.Flow

class OfflineNoteRepository(private val noteDao: NoteDao) : NoteRepository {
    override suspend fun insertNotes(entity: Note) = noteDao.insert(entity)

    override suspend fun updateNotes(entity: Note) = noteDao.update(entity)

    override suspend fun deleteNotes(entity: Note) = noteDao.delete(entity)

    override fun getNotes(id: Int): Flow<Note?> = noteDao.getNote(id)
}