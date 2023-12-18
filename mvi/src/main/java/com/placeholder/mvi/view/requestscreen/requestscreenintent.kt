package com.placeholder.mvi.view.requestscreen

sealed class RequestTodoIntent {
    object FetchTodos : RequestTodoIntent()
}