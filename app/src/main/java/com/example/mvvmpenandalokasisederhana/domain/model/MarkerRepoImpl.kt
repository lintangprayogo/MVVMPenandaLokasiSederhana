package com.example.mvvmpenandalokasisederhana.domain.model

import com.example.mvvmpenandalokasisederhana.data.MarkerDao
import com.example.mvvmpenandalokasisederhana.domain.asEntity
import com.example.mvvmpenandalokasisederhana.domain.asModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MarkerRepoImpl(val markerDao: MarkerDao) : MarkerRepo {
    override suspend fun deleteMarker(marker: MarkerModel) {
        markerDao.delete(marker.asEntity())
    }

    override suspend fun insertMarker(marker: MarkerModel) {
        markerDao.insert(marker.asEntity())
    }

    override fun getMarker(): Flow<List<MarkerModel>> {
      return  markerDao.getParkingSpot().map {spots->
          spots.map {spot->
              spot.asModel()
          }
        }
    }
}