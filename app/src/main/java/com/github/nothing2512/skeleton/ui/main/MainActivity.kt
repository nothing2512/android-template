package com.github.nothing2512.skeleton.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.github.nothing2512.skeleton.R
import com.github.nothing2512.skeleton.databinding.ActivityMainBinding
import com.github.nothing2512.skeleton.utilities.launchMain
import com.github.nothing2512.skeleton.vm.GithubViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val githubViewModel: GithubViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        launchMain {
            githubViewModel.getUsers()
            githubViewModel.users.observe(this@MainActivity) {
                binding.content.text = "Okay"
            }
        }
    }
}