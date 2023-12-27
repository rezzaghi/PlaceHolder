package com.placeholder.mvvm.di

import android.app.Application
import com.placeholder.mvvm.data.repository.PlaceHolderRepository
import com.placeholder.mvvm.data.repository.PlaceHolderRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent

@HiltAndroidApp
class MviApplication : Application() {
}

@Module
@InstallIn(SingletonComponent::class)
abstract class PlaceHolderModule {
    @Binds
    abstract fun bindPlaceHolderRepository(impl: PlaceHolderRepositoryImpl): PlaceHolderRepository
}