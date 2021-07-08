package com.example.composeapp.usecase

import com.example.composeapp.datasource.model.Params
import com.example.composeapp.datasource.repository.PuppyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PuppyUseCase
@Inject
constructor(val repository: PuppyRepository) {
    fun execute(params: Params): Flow<*> {
        return repository.work(params)
    }
}