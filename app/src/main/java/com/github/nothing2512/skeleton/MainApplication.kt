package com.github.nothing2512.skeleton

import android.app.Application
import androidx.viewbinding.BuildConfig
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application(), Configuration.Provider {
    override fun getWorkManagerConfiguration() = Configuration.Builder()
        .setMinimumLoggingLevel(if(BuildConfig.DEBUG) android.util.Log.DEBUG else android.util.Log.ERROR)
        .build()
}