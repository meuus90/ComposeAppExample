package com.example.composeapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapp.datasource.model.Params
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {
    private var sharedDataFlow: SharedFlow<Params>? = null

    internal fun <T : Any> share(data: T) {
        sharedDataFlow = flow {
            emit(Params(data))
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = Params(data)
        )
    }

    internal fun shared(doOnResult: (data: Params) -> Unit) {
        viewModelScope.launch {
            sharedDataFlow?.collectLatest { data ->
                doOnResult(data)
            }
        }
    }
}