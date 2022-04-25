package com.example.finansmobile

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SongRepository @Inject constructor(private val iTunesApi: RetroService,
                                         private val songDao: SongDAO) {

    fun getSongList() = songDao.getList()

    suspend  fun fetchFromNetwork(artistName:String) {
        withContext(Dispatchers.IO) {
            val response =  iTunesApi.searchSongs(artistName)
            response.body()?.let {
                songDao.insert(it.results)
            }
        }
    }

    suspend fun deleteAllSongs() = songDao.deleteAllSongs()

}