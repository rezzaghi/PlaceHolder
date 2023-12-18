package com.placeholder.mvi.data.repository

import com.placeholder.mvi.data.model.Todos
import kotlinx.coroutines.flow.Flow

interface PlaceHolderRepository {
    fun getTodos(): Flow<Todos>
}