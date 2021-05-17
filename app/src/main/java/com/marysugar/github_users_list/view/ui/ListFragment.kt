package com.marysugar.github_users_list.view.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.marysugar.github_users_list.R
import com.marysugar.github_users_list.databinding.FragmentListBinding
import com.marysugar.github_users_list.model.User
import com.marysugar.github_users_list.view.adapter.UserAdapter
import com.marysugar.github_users_list.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {
    private val userViewModel by viewModel<UserViewModel>()
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
        userViewModel.data.observe(this, {
            Log.d("ListFragment", it.toString())
            it.let(userAdapter::submitList)
        })
    }

    private fun partItemClicked(user : User) {
        Toast.makeText(context, "Clicked: ${user.id}", Toast.LENGTH_LONG).show()
    }
}