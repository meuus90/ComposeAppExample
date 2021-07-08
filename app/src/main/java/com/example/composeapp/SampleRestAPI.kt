package com.example.composeapp

import com.example.composeapp.datasource.RestAPI
import com.example.composeapp.datasource.model.Puppy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.Query

class SampleRestAPI : RestAPI {
    override fun getPuppies(): Flow<List<Puppy>> {
        return flow {
            emit(SampleData.puppyList)
        }
    }

    override fun getPuppy(@Query("id") id: Int): Flow<Puppy> {
        return flow {
            SampleData.puppyList.find { it.id == id }?.let { emit(it) }
        }
    }
}