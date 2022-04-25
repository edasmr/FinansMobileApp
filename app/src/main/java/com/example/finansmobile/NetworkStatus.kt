package com.example.finansmobile

sealed class NetworkStatus {
    object Success : NetworkStatus()
    object Loading : NetworkStatus()
    object Error : NetworkStatus()
}

