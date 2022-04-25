package com.example.finansmobile

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    @GET("search")
    suspend fun searchSongs(
        @Query("term") artist:String
    ): Response<ITunesApiResponse>
}