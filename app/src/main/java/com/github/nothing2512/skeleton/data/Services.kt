package com.github.nothing2512.skeleton.data

import androidx.lifecycle.LiveData
import com.github.nothing2512.skeleton.data.entities.UserEntities
import com.github.nothing2512.skeleton.utilities.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Services {

    @GET("users")
    suspend fun getUsers(): ArrayList<UserEntities>

    companion object {
        fun create(): Services = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC })
                    .build()
            ).build()
            .create(Services::class.java)
    }
}