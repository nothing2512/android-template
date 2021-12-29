package com.github.nothing2512.skeleton.data.repositories

import androidx.lifecycle.MediatorLiveData
import com.github.nothing2512.skeleton.data.Services
import com.github.nothing2512.skeleton.data.entities.UserEntities
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubRepository @Inject constructor(private val services: Services) {

    val users = MediatorLiveData<ArrayList<UserEntities>>()

    suspend fun getUsers() {
        services.getUsers().let { users.postValue(it) }
    }
}