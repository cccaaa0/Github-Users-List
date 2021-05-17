package com.marysugar.github_users_list.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.marysugar.github_users_list.databinding.ItemUserBinding
import com.marysugar.github_users_list.model.User

class UserAdapter(val clickListener: (User) -> Unit)
    : ListAdapter<User, UserAdapter.UserViewHolder>(Companion) {

    class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    companion object: DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(layoutInflater)

        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = getItem(position)
        holder.binding.user = currentUser
        holder.binding.executePendingBindings()

        holder.binding.parent.setOnClickListener {
            clickListener(currentUser)
        }
    }
}