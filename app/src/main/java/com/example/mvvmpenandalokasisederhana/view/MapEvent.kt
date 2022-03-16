package com.example.mvvmpenandalokasisederhana.view

import com.example.mvvmpenandalokasisederhana.domain.model.MarkerModel
import com.google.android.gms.maps.model.LatLng

sealed class MapEvent {
    object ToggleMapEvent : MapEvent()
    data class onMapClick(val latLng: LatLng):MapEvent()
    data class onMarkerClick(val markerModel: MarkerModel):MapEvent()
}
