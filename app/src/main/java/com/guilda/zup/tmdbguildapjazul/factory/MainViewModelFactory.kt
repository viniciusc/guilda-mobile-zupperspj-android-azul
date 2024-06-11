package com.guilda.zup.tmdbguildapjazul.factory

import com.guilda.zup.tmdbguildapjazul.viewmodel.MainViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guilda.zup.tmdbguildapjazul.usecase.GetDataUseCase

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            //TODO: apply dependency injection
            val getDataUseCase = GetDataUseCase()
            return MainViewModel(getDataUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}