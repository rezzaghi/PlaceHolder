package com.placeholder.mvvm.view.requestscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.placeholder.mvvm.data.repository.PlaceHolderRepository
import com.placeholder.mvvm.view.states.TodoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RequestViewModel @Inject constructor(
    private val repository: PlaceHolderRepository
) : ViewModel() {
    private val _state = MutableStateFlow(TodoState())
    val state: StateFlow<TodoState> = _state.asStateFlow()

    fun getTodos() {
        viewModelScope.launch {
            repository.getTodos()
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    _state.value = _state.value.copy(todos = null)
                }
                .collect { todos ->
                    _state.value = _state.value.copy(todos = todos)
                }
        }
    }
}