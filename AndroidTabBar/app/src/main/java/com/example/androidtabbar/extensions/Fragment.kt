package com.example.androidtabbar.extensions

import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.androidtabbar.R


// Use for bottom navigation forward transition
fun <T: Fragment> Fragment.pushBottomNavigation(navigationId: Int, fragment: T) {
    requireActivity().supportFragmentManager.beginTransaction()
        .setCustomAnimations(R.anim.slide_from_left_in, R.anim.slide_from_left_out)
        .add(navigationId, fragment)
        .addToBackStack(null)
        .commit()
}

// Use for bottom navigation back transition
fun <T: Fragment>Fragment.popBottomNavigation(fragment: T) {
    val animation: Animation = AnimationUtils.loadAnimation(requireActivity(), R.anim.slide_from_right_out)
    animation.duration = resources.getInteger(android.R.integer.config_shortAnimTime).toLong()
    animation.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {}
        override fun onAnimationRepeat(animation: Animation?) {}
        override fun onAnimationEnd(animation: Animation?) {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.remove(fragment)
            fragmentTransaction.commitAllowingStateLoss()
        }
    })
    requireView().startAnimation(animation)
}
