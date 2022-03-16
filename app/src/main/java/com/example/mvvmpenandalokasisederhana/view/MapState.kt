package com.example.mvvmpenandalokasisederhana.view

import com.example.mvvmpenandalokasisederhana.domain.model.MarkerModel
import com.google.maps.android.compose.MapProperties

data class MapState(
    val markers: List<MarkerModel> = emptyList(),
    val mapProperties: MapProperties = MapProperties(),
    val isWatchDogMap: Boolean
)