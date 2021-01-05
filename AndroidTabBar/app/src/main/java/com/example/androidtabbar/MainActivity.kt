package com.example.androidtabbar

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentContainerView
import com.example.androidtabbar.fragments.UserProfileFragment
import com.example.androidtabbar.fragments.UsersListFragment


class MainActivity : AppCompatActivity() {

    private lateinit var fragmentContainer: ConstraintLayout
    private lateinit var bottomNavigationLinearLayout: LinearLayout

    private lateinit var userProfileFragment: UserProfileFragment
    private lateinit var interlocutorSearchFragment: UsersListFragment

    private lateinit var profileContainerView: FragmentContainerView
    private lateinit var interlocutorContainerView: FragmentContainerView

    private lateinit var fragmentsList: List<Fragment>
    private lateinit var buttonsList: List<ImageButton>
    private lateinit var containersList: List<FragmentContainerView>

    // Activity Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instantiateUIComponents()
        initFragments()
        setupFragmentsList()
        setupInitialBottomNavigationBar()
    }

    // Setup
    private fun instantiateUIComponents() {
        fragmentContainer = findViewById(R.id.fragmentContainer)
        bottomNavigationLinearLayout = findViewById(R.id.bottomNavigationLinearLayout)
    }

    private fun initFragments() {
        val userProfileNavHost = R.id.userProfileNavHost
        val topUsersNavHost = R.id.topUsersNavHost

        userProfileFragment = UserProfileFragment(userProfileNavHost)
        interlocutorSearchFragment = UsersListFragment(topUsersNavHost)

        supportFragmentManager.beginTransaction().apply {
            add(userProfileNavHost, userProfileFragment)
            add(topUsersNavHost, interlocutorSearchFragment)
        }.commit()

        profileContainerView = findViewById(userProfileNavHost)
        interlocutorContainerView = findViewById(topUsersNavHost)
        containersList = listOf(profileContainerView, interlocutorContainerView)

        profileContainerView.visibility = View.VISIBLE
        interlocutorContainerView.visibility = View.INVISIBLE
    }

    private fun setupFragmentsList() {
        fragmentsList = listOf(userProfileFragment, interlocutorSearchFragment)
    }

    private fun setupInitialBottomNavigationBar() {
        val userProfileButton = findViewById<ImageButton>(R.id.userProfileButton)
        val topUsersButton = findViewById<ImageButton>(R.id.topUsersButton)
        buttonsList = listOf(userProfileButton, topUsersButton)
        buttonsList.forEach {
            it.setOnClickListener { button -> setupControllersVisibilityFor(button as ImageButton) }
        }
        setupBottomNavigationSelected(userProfileButton)
    }

    // Navigation Utils
    private fun setupControllersVisibilityFor(button: ImageButton) {
        val buttonIndex = buttonsList.indexOf(button)
        val selectedController = containersList[buttonIndex]
        containersList.forEach {
            it.visibility = if (it == selectedController) View.VISIBLE else View.GONE
        }

        setupBottomNavigationSelected(button)
    }

    private fun setupBottomNavigationSelected(button: ImageButton) {
        buttonsList.forEach {
            if (it == button) {
                it.setColorFilter(
                    ContextCompat.getColor(baseContext, R.color.bottomNavigationTabHighlighted),
                    PorterDuff.Mode.SRC_ATOP
                )
            } else {
                it.setColorFilter(
                    ContextCompat.getColor(baseContext, R.color.bottomNavigationTabNormal),
                    PorterDuff.Mode.SRC_ATOP
                )
            }
        }
    }
}