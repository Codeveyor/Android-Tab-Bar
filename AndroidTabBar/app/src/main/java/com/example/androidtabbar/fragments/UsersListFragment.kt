package com.example.androidtabbar.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtabbar.R
import com.example.androidtabbar.dataSource.DataSource
import com.example.androidtabbar.dataSource.User
import com.example.androidtabbar.dataSource.UsersAdapter
import com.example.androidtabbar.extensions.popBottomNavigation
import com.example.androidtabbar.extensions.pushBottomNavigation
import com.example.androidtabbar.utils.RootFragment


class UsersListFragment(navHostId: Int) :
    RootFragment(navHostId),
    UsersAdapter.OnItemClickListener {

    private lateinit var backButton: ImageButton
    private lateinit var usersRecyclerView: RecyclerView

    private lateinit var adapter: UsersAdapter

    var user: User? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_users_list, container, false)
        instantiateUIComponents(rootView)
        setupBackButtonVisibility()
        setupRecyclerView()
        setupBackButtonListener()
        return rootView
    }

    // UsersAdapter.OnItemClickListener
    override fun onItemClick(model: User, view: View) {
        val userProfileFragment = UserProfileFragment(navHost)
        userProfileFragment.user = model
        pushBottomNavigation(navHost, userProfileFragment)
    }

    // Utils
    private fun instantiateUIComponents(rootView: View) {
        backButton = rootView.findViewById(R.id.backButton)
        usersRecyclerView = rootView.findViewById(R.id.usersRecyclerView)
    }

    private fun setupBackButtonVisibility() {
        if (user != null) {
            backButton.visibility = View.VISIBLE
        } else {
            user = DataSource.fetchRandomUser()
            backButton.visibility = View.INVISIBLE
        }
    }

    private fun setupRecyclerView() {
        val userFriends = DataSource.fetchRandomFriendsFor(user)
        adapter = UsersAdapter(
            requireContext(),
            userFriends,
            this
        )
        usersRecyclerView.adapter = adapter
        usersRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter.notifyDataSetChanged()
    }

    private fun setupBackButtonListener() {
        backButton.setOnClickListener { popBottomNavigation(this) }
    }
}