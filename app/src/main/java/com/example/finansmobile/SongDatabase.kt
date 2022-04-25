package com.example.finansmobile

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Song::class],version = 1,exportSchema = false)
abstract class SongDatabase : RoomDatabase() {

    abstract fun getDao(): SongDAO
}