package com.marysugar.github_users_list.view.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.marysugar.github_users_list.R
import com.marysugar.github_users_list.databinding.FragmentUserRepositoryBinding
import com.marysugar.github_users_list.viewmodel.GithubViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class UserRepositoryFragment : Fragment() {
    private val githubViewModel by sharedViewModel<GithubViewModel>()
    private lateinit var binding: FragmentUserRepositoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, githubViewModel.login)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_user_repository,
            container,
            false
        )

        return binding.root
    }

    companion object {
        const val TAG = "UserRepositoryFragment"
    }
}