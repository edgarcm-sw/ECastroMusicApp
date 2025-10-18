package com.example.ecastromusicapp.services

import com.example.ecastromusicapp.data.model.Album
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumService {
    @GET("almbums")
    suspend fun getAllAbum() : List<Album>

    @GET("albums/{id}")
    suspend fun getAlbumById(@Path("id") id : Int) : Album
}