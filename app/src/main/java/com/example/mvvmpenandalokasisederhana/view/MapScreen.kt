package com.example.mvvmpenandalokasisederhana.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker

@Composable
fun MapScreen(mapViewModel: MapViewModel = viewModel()) {
    val scaffoldState = rememberScaffoldState()
    val uiSettings = remember {
        MapUiSettings(zoomControlsEnabled = false)
    }


    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = { mapViewModel.onEvent(MapEvent.ToggleMapEvent) }) {
                Icon(
                    imageVector =
                    if (mapViewModel.mapState.isWatchDogMap) {
                        Icons.Default.ToggleOff
                    } else {
                        Icons.Default.ToggleOn
                    }, contentDescription = "Toggle"
                )

            }
        }
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            properties = mapViewModel.mapState.mapProperties,
            uiSettings = uiSettings,
            onMapLongClick = {
                mapViewModel.onEvent(MapEvent.onMapClick(latLng = it))
            }
        ) {
            mapViewModel.mapState.markers.forEach { markerModel ->
                Marker(position = LatLng(markerModel.latitude, markerModel.longitude),
                    title = "Marker Cordinate (${markerModel.latitude}${markerModel.longitude})",
                    snippet = "Long Click To Delete",
                    onInfoWindowLongClick = {
                        mapViewModel.onEvent(MapEvent.onMarkerClick(markerModel))
                    })
            }
        }
    }
}