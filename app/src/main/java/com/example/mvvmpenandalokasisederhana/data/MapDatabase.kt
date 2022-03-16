package com.example.mvvmpenandalokasisederhana.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MarkerEntity::class],
    version = 1
)
abstract class MapDatabase:RoomDatabase() {
    abstract val markerDao: MarkerDao
}