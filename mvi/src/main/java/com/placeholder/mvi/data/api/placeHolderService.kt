package com.placeholder.mvi.data.api

import com.placeholder.mvi.data.model.Todos
import retrofit2.http.GET

interface PlaceHolderService {
    @GET("todos/1")
    suspend fun getTodos(): Todos
}