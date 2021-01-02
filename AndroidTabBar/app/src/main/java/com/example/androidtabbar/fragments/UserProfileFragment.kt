package com.example.androidtabbar.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtabbar.R
import com.example.androidtabbar.dataSource.DataSource
import com.example.androidtabbar.utils.RootFragment


class UserProfileFragment(navHostId: Int): RootFragment(navHostId) {

    private lateinit var backButton: ImageButton
    private lateinit var avatarImageView: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var instrumentTextView: TextView
    private lateinit var friendsRecyclerView: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_user_profile, container, false)
        instantiateUIComponents(rootView)
        setupUser()

        return rootView
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
        val user = DataSource.fetchRandomUser()
        avatarImageView.setImageDrawable(resources.getDrawable(user.avatar))
        nameTextView.text = "${user.firstName} ${user.lastName}"
        instrumentTextView.text = user.instrument
    }
}
