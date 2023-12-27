package com.placeholder.mvvm.data.repository

import com.placeholder.mvvm.data.model.Todos
import kotlinx.coroutines.flow.Flow

interface PlaceHolderRepository {
    fun getTodos(): Flow<Todos>
}