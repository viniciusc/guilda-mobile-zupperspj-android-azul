package com.guilda.zup.tmdbguildapjazul.viewmodel

import androidx.lifecycle.ViewModel
import com.guilda.zup.tmdbguildapjazul.interfaces.UseCase

abstract class BaseViewModel<T>(private val useCase: UseCase<T>) : ViewModel()