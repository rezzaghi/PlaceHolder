package com.placeholder.mvi.di

import android.app.Application
import com.placeholder.mvi.data.repository.PlaceHolderRepository
import com.placeholder.mvi.data.repository.PlaceHolderRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ViewModelComponent

@HiltAndroidApp
class MviApplication : Application() {
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class PlaceHolderModule {
    @Binds
    abstract fun bindPlaceHolderRepository(impl: PlaceHolderRepositoryImpl): PlaceHolderRepository
}