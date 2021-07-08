package com.example.composeapp.usecase

import com.example.composeapp.datasource.model.Params
import com.example.composeapp.datasource.repository.PuppiesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PuppiesUseCase
@Inject
constructor(val repository: PuppiesRepository) {
    fun execute(params: Params): Flow<*> {
        return repository.work(params)
    }
}