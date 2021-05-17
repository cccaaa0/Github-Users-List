package com.marysugar.github_users_list.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.marysugar.github_users_list.R
import com.marysugar.github_users_list.view.adapter.UserAdapter
import com.marysugar.github_users_list.viewmodel.UserViewModel
import com.marysugar.github_users_list.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val userViewModel by viewModel<UserViewModel>()
    private val binding : ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            lifecycleOwner = this@MainActivity
            viewModel = userViewModel
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userAdapter = UserAdapter()

        binding.adapter = userAdapter

        // Observe data from viewModel
        userViewModel.data.observe(this, Observer {
            Log.e("MainActivity", it.toString())
            it.let(userAdapter::submitList)
        })
    }
}