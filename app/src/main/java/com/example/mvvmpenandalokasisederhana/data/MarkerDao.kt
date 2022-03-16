package com.example.mvvmpenandalokasisederhana.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MarkerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(markerEntity: MarkerEntity)

    @Delete
    suspend fun delete(markerEntity: MarkerEntity)

    @Query("Select * FROM Marker")
    fun getParkingSpot(): Flow<List<MarkerEntity>>
}