package com.example.composeapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {
    private var sharedDataFlow: SharedFlow<SharedData>? = null

    internal fun <T : Any> share(data: T) {
        sharedDataFlow = flow {
            emit(SharedData(data))
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = SharedData(data)
        )
    }

    internal fun shared(doOnResult: (data: SharedData) -> Unit) {
        viewModelScope.launch {
            sharedDataFlow?.collectLatest { data ->
                doOnResult(data)
            }
        }
    }
}

data class SharedData(val param: Any)