package com.example.androidtabbar.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtabbar.R
import com.example.androidtabbar.dataSource.User
import com.example.androidtabbar.dataSource.UsersAdapter
import com.example.androidtabbar.utils.RootFragment


class UsersListFragment(navHostId: Int) :
    RootFragment(navHostId),
    UsersAdapter.OnItemClickListener {

    private lateinit var backButton: ImageButton
    private lateinit var friendsRecyclerView: RecyclerView

    private lateinit var adapter: UsersAdapter

    var user: User? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_users_list, container, false)
    }

    // UsersAdapter.OnItemClickListener
    override fun onItemClick(model: User, view: View) {
        // TODO:
    }

    // Utils
    private fun instantiateUIComponents(rootView: View) {
        backButton = rootView.findViewById(R.id.backButton)
        friendsRecyclerView = rootView.findViewById(R.id.friendsRecyclerView)
    }

    private fun setupRecyclerView() {
//        user?.let {
//            val userFriends = DataSource.fetchRandomFriendsFor(it)
//            adapter = UsersAdapter(
//                requireContext(),
//                userFriends,
//                this
//            )
//            friendsRecyclerView.adapter = adapter
//            friendsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
//
//            adapter.notifyDataSetChanged()
//        }
    }
}