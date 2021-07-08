package com.example.composeapp.datasource

import com.example.composeapp.datasource.model.Puppy
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface RestAPI {
    @GET("puppies")
    fun getPuppies(): Flow<List<Puppy>>

    @GET("puppy")
    fun getPuppy(@Query("id") id: Int): Flow<Puppy>
}