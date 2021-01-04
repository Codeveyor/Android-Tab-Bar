package com.example.androidtabbar.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtabbar.R
import com.example.androidtabbar.dataSource.DataSource
import com.example.androidtabbar.dataSource.User
import com.example.androidtabbar.dataSource.UsersAdapter
import com.example.androidtabbar.utils.RootFragment


class UserProfileFragment(navHostId: Int) :
    RootFragment(navHostId),
    UsersAdapter.OnItemClickListener {

    private lateinit var backButton: ImageButton
    private lateinit var avatarImageView: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var instrumentTextView: TextView
    private lateinit var friendsRecyclerView: RecyclerView

    private lateinit var adapter: UsersAdapter

    var user: User? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_user_profile, container, false)
        instantiateUIComponents(rootView)
        setupUser()
        setupRecyclerView()
        return rootView
    }

    // UsersAdapter.OnItemClickListener
    override fun onItemClick(model: User, view: View) {
        // TODO:
    }

    // Utils
    private fun instantiateUIComponents(rootView: View) {
        backButton = rootView.findViewById(R.id.backButton)
        avatarImageView = rootView.findViewById(R.id.userAvatarImageView)
        nameTextView = rootView.findViewById(R.id.nameTextView)
        instrumentTextView = rootView.findViewById(R.id.instrumentTextView)
        friendsRecyclerView = rootView.findViewById(R.id.friendsRecyclerView)
    }

    private fun setupUser() {
        user = DataSource.fetchRandomUser()
        avatarImageView.setImageDrawable(user?.avatar?.let { resources.getDrawable(it) })
        nameTextView.text = "${user?.firstName} ${user?.lastName}"
        instrumentTextView.text = user?.instrument
    }

    private fun setupRecyclerView() {
        user?.let {
            val userFriends = DataSource.fetchRandomFriendsFor(it)
            adapter = UsersAdapter(
                requireContext(),
                userFriends,
                this
            )
            friendsRecyclerView.adapter = adapter
            friendsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

            adapter.notifyDataSetChanged()
        }
    }
}
