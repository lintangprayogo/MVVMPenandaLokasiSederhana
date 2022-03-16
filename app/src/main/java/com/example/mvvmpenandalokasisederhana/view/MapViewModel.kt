package com.example.mvvmpenandalokasisederhana.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmpenandalokasisederhana.domain.model.MarkerModel
import com.example.mvvmpenandalokasisederhana.domain.model.MarkerRepo
import com.google.android.gms.maps.model.MapStyleOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(private val markerRepo: MarkerRepo) : ViewModel() {

    var mapState by mutableStateOf(MapState(isWatchDogMap = false))

    init {

        viewModelScope.launch {
            markerRepo.getMarker().collectLatest {
                mapState = mapState.copy(markers = it)
            }
        }
    }

    fun onEvent(event: MapEvent) {
        when (event) {
            is MapEvent.ToggleMapEvent -> {
                val mapProperties = if (mapState.isWatchDogMap) {
                    mapState.mapProperties.copy(mapStyleOptions = null)
                } else {
                    mapState.mapProperties.copy(mapStyleOptions = MapStyleOptions(MapStyle.jsonStyle))
                }
                mapState = mapState.copy(
                    mapProperties = mapProperties,
                    isWatchDogMap = !mapState.isWatchDogMap
                )
            }
            is MapEvent.onMapClick -> {
                viewModelScope.launch {
                    markerRepo.insertMarker(
                        MarkerModel(
                            latitude = event.latLng.latitude,
                            longitude = event.latLng.longitude,
                        )
                    )
                }
            }
            is MapEvent.onMarkerClick -> {
                viewModelScope.launch {
                    markerRepo.deleteMarker(event.markerModel)
                }
            }
        }
    }
}