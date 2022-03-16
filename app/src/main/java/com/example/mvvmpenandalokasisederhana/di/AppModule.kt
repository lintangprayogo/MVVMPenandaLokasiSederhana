package com.example.mvvmpenandalokasisederhana.di

import android.app.Application
import androidx.room.Room
import com.example.mvvmpenandalokasisederhana.data.MapDatabase
import com.example.mvvmpenandalokasisederhana.domain.model.MarkerRepo
import com.example.mvvmpenandalokasisederhana.domain.model.MarkerRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDB(app: Application): MapDatabase =
        Room.databaseBuilder(
            app,
            MapDatabase::class.java,
            "map_db"
        ).build()

    @Singleton
    @Provides
    fun provideRepo(mapDatabase: MapDatabase): MarkerRepo = MarkerRepoImpl(mapDatabase.markerDao)

}