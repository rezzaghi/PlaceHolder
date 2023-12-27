package com.placeholder.mvvm.data.repository

import com.placeholder.mvvm.data.api.PlaceHolderService
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import javax.inject.Inject

class PlaceHolderRepositoryImpl @Inject constructor(
    retrofit: Retrofit
) : PlaceHolderRepository {
    private val endpoint = retrofit.create(PlaceHolderService::class.java)

    override fun getTodos() = flow {
        emit(endpoint.getTodos())
    }
}