package com.example.mvvmpenandalokasisederhana.domain.model

import kotlinx.coroutines.flow.Flow


interface MarkerRepo {
    suspend fun deleteMarker(marker: MarkerModel)
    suspend fun insertMarker(marker: MarkerModel)
    fun  getMarker():Flow<List<MarkerModel>>
}