package com.example.kotlin_notes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Entity::class], version = 1, exportSchema = false)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun EntityDao(): EntityDao

    companion object {
        @Volatile //БД всега актуально
        private var Instance: RoomDatabase? = null //ссылка на БД

        fun getDatabase(context: Context): RoomDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, RoomDatabase::class.java, "database")
                    .build().also { Instance = it }
            }
        }
    }
}