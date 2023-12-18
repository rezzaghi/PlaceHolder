package com.placeholder.mvi.view.requestscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.placeholder.mvi.data.repository.PlaceHolderRepositoryImpl
import com.placeholder.mvi.view.states.TodoState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class RequestViewModel: ViewModel() {
    //TODO: use Hilt
    private val repository = PlaceHolderRepositoryImpl()
    private val _state = MutableStateFlow(TodoState())
    val state: StateFlow<TodoState> = _state.asStateFlow()

    fun processIntent(intent: RequestTodoIntent) {
        when (intent) {
            RequestTodoIntent.FetchTodos -> getTodos()
        }
    }

    private fun getTodos() {
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