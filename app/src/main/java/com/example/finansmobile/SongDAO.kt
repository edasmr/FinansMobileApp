package com.example.finansmobile

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SongDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(songList:List<Song>)

    @Query("SELECT * FROM song_table ORDER BY id DESC")
    fun getList(): LiveData<List<Song>>

    @Query("DELETE FROM song_table")
    suspend fun deleteAllSongs()
}