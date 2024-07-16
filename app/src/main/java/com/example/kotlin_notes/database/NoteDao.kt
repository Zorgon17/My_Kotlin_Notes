package com.example.kotlin_notes.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * from Note WHERE noteId = :noteId")
    fun getNote(noteId: Int): Flow<Note>

    @Query("SELECT * from Note ORDER BY noteId ASC")
    fun getAllNotes(): Flow<List<Note>>
}