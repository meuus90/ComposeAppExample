package com.example.composeapp.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapp.datasource.model.Params
import com.example.composeapp.datasource.model.Puppy
import com.example.composeapp.usecase.PuppiesUseCase
import com.example.composeapp.usecase.PuppyUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Singleton
class PuppyViewModel
@ViewModelInject
constructor(
    private val puppiesUseCase: PuppiesUseCase,
    private val puppyUseCase: PuppyUseCase
) : ViewModel() {
    fun getPuppies(params: Params, doOnResult: (result: List<Puppy>) -> Unit) {
        viewModelScope.launch {
            puppiesUseCase.execute(params).collectLatest {
                doOnResult(it as List<Puppy>)
            }
        }
    }

    fun getPuppy(params: Params, doOnResult: (result: Puppy) -> Unit) {
        viewModelScope.launch {
            puppyUseCase.execute(params).collectLatest {
                doOnResult(it as Puppy)
            }
        }
    }
}