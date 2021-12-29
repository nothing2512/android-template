package com.github.nothing2512.skeleton.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.nothing2512.skeleton.data.entities.UserEntities
import com.github.nothing2512.skeleton.data.repositories.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject internal constructor(private val githubRepository: GithubRepository) :
    ViewModel() {

    val users: LiveData<ArrayList<UserEntities>> = githubRepository.users

    fun getUsers() {
        viewModelScope.launch {
            githubRepository.getUsers()
        }
    }
}