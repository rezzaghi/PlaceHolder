package com.placeholder.mvi.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PlaceHolderApi {
    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
