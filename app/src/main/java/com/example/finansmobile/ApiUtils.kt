package com.example.finansmobile

class ApiUtils {
    companion object {
        private const val BASE_URL = "https://itunes.apple.com/"

        fun usersDAOInterface(): RetroService {
            return RetrofitClient.getClient(BASE_URL).create(RetroService::class.java)
        }
    }
}