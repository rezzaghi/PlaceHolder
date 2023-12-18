package com.placeholder.mvi.view.states

import com.placeholder.mvi.data.model.Todos

data class TodoState(
    val todos: Todos? = null,
)