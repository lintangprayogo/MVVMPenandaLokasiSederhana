package com.example.mvvmpenandalokasisederhana.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Marker")
data class MarkerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val longitude: Double,
    val latitude: Double
)
