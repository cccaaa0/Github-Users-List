package com.marysugar.github_users_list.view.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marysugar.github_users_list.R
import com.marysugar.github_users_list.viewmodel.GithubViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class UserRepositoryFragment : Fragment() {
    private val githubViewModel by sharedViewModel<GithubViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, githubViewModel.login)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_repository, container, false)
    }

    companion object {
        const val TAG = "UserRepositoryFragment"
    }
}