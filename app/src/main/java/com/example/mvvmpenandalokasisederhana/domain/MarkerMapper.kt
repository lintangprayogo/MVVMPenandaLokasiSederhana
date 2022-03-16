package com.example.mvvmpenandalokasisederhana.domain

import com.example.mvvmpenandalokasisederhana.data.MarkerEntity
import com.example.mvvmpenandalokasisederhana.domain.model.MarkerModel


fun MarkerEntity.asModel(): MarkerModel = MarkerModel(
    id = this.id,
    latitude = this.latitude,
    longitude = this.longitude
)

fun MarkerModel.asEntity(): MarkerEntity = MarkerEntity(
    id = this.id?:0,
    latitude = this.latitude,
    longitude = this.longitude
)