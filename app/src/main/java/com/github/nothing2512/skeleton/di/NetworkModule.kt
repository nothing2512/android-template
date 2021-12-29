package com.github.nothing2512.skeleton.di

import com.github.nothing2512.skeleton.data.Services
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideServices(): Services = Services.create()
}