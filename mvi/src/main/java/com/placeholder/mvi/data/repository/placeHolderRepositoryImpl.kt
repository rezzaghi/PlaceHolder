package com.placeholder.mvi.data.repository

import com.placeholder.mvi.data.api.PlaceHolderApi
import com.placeholder.mvi.data.api.PlaceHolderService
import kotlinx.coroutines.flow.flow

class PlaceHolderRepositoryImpl: PlaceHolderRepository {
    //TODO: DI
    private val retrofitClient = PlaceHolderApi
        .getRetrofitInstance()
    private val endpoint = retrofitClient.create(PlaceHolderService::class.java)

    override fun getTodos() = flow {
        emit(endpoint.getTodos())
    }
}