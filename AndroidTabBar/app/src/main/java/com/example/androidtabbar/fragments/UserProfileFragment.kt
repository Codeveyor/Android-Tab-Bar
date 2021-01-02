package com.example.androidtabbar.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtabbar.R
import com.example.androidtabbar.utils.RootFragment


class UserProfileFragment(navHostId: Int): RootFragment(navHostId) {

    private lateinit var backButton: ImageButton
    private lateinit var avatarImageView: ImageView
    private lateinit var friendsRecyclerView: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_user_profile, container, false)
        instantiateUIComponents(rootView)

        // TODO:
        avatarImageView.setImageDrawable(resources.getDrawable(R.drawable.alex))
        return rootView
    }

    // Utils
    private fun instantiateUIComponents(rootView: View) {
        backButton = rootView.findViewById(R.id.backButton)
        avatarImageView = rootView.findViewById(R.id.userAvatarImageView)
        friendsRecyclerView = rootView.findViewById(R.id.friendsRecyclerView)
    }
}
