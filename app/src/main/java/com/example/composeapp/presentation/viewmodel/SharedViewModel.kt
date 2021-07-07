package com.example.composeapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

open class SharedViewModel<T> : ViewModel() {
    private var sharedData: SharedFlow<T>? = null

    internal fun share(data: T) {
        sharedData = flow {
            emit(data)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = data
        )
    }

    internal fun shared(doOnResult: (data: T) -> Unit) {
        viewModelScope.launch {
            sharedData?.collectLatest { data ->
                data?.let { doOnResult(data) }
            }
        }
    }
}