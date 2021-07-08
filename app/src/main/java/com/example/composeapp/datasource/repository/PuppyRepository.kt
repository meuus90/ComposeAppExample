package com.example.composeapp.datasource.repository

import com.example.composeapp.datasource.RestAPI
import com.example.composeapp.datasource.model.Params
import com.example.composeapp.datasource.model.Puppy
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PuppyRepository
@Inject
constructor() {
    @Inject
    lateinit var restAPI: RestAPI

    fun work(params: Params): Flow<*> {
        return restAPI.getPuppy(params.param as Int)
    }
}