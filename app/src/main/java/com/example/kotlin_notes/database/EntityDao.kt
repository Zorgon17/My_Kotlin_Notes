package com.example.kotlin_notes.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface EntityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: Entity)

    @Update
    suspend fun update(entity: Entity)

    @Delete
    suspend fun delete(entity: Entity)

    @Query("SELECT * from Entity WHERE noteId = :noteId")
    fun getNote(noteId: Int): Flow<Entity>
}