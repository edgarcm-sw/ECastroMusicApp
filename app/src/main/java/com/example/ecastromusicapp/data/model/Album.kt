package com.example.ecastromusicapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Album(
    val id: Int,
    val title: String,
    val artist: String,
    val image: String,
    val description: String? = null
)