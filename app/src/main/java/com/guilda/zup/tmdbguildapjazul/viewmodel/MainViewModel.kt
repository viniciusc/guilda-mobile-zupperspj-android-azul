package com.guilda.zup.tmdbguildapjazul.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guilda.zup.tmdbguildapjazul.model.UiState
import com.guilda.zup.tmdbguildapjazul.usecase.GetDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val getDataUseCase: GetDataUseCase) : BaseViewModel<String>(getDataUseCase) {

    private val _uiStateLiveData = MutableStateFlow<UiState<String>>(UiState.Loading)

    val uiStateLiveData: StateFlow<UiState<String>> = _uiStateLiveData

    init {
        viewModelScope.launch {

            getDataUseCase.getData().collect { uiState ->
                _uiStateLiveData.value = uiState
            }
        }
    }
}