package com.example.finansmobile

import android.content.Context
import androidx.room.Room
import com.example.finansmobile.ConstantsBaseUrl.Companion.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): SongDatabase =
        Room.databaseBuilder(context,SongDatabase::class.java,"song_database")
            .build()

    @Provides
    fun providesDao(songDatabase: SongDatabase): SongDAO =
        songDatabase.getDao()

    @Provides
    @Singleton
    fun providesMoshiInstance() : Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


    @Provides
    @Singleton
    fun providesRetrofitInstance(moshi: Moshi) : Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    @Singleton
    fun providesITunesApi(retrofit: Retrofit) : RetroService =
        retrofit.create(RetroService::class.java)
}