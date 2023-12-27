package com.placeholder.mvvm.data.api

import com.placeholder.mvvm.data.model.Todos
import retrofit2.http.GET

interface PlaceHolderService {
    @GET("todos/1")
    suspend fun getTodos(): Todos
}