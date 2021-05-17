package com.marysugar.github_users_list.view.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.marysugar.github_users_list.R
import com.marysugar.github_users_list.databinding.FragmentListBinding
import com.marysugar.github_users_list.model.User
import com.marysugar.github_users_list.view.adapter.UserAdapter
import com.marysugar.github_users_list.viewmodel.GithubViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ListFragment : Fragment() {
    private val githubViewModel by sharedViewModel<GithubViewModel>()
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list,
            container,
            false
        )

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val userAdapter = UserAdapter { user: User -> partItemClicked(user) }
        binding.adapter = userAdapter
        // Observe data from viewModel
        githubViewModel.data.observe(this, {
            Log.d("ListFragment", it.toString())
            it.let(userAdapter::submitList)
        })
    }

    private fun partItemClicked(user : User) {
        githubViewModel.login = user.login
        findNavController().navigate(R.id.action_listFragment_to_userRepositoryFragment)
    }
}