package com.example.mvvmpenandalokasisederhana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.mvvmpenandalokasisederhana.ui.theme.MVVMPencariParkirSederhanaTheme
import com.example.mvvmpenandalokasisederhana.view.MapScreen
import com.example.mvvmpenandalokasisederhana.view.MapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMPencariParkirSederhanaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MapScreen()
                }
            }
        }
    }
}

