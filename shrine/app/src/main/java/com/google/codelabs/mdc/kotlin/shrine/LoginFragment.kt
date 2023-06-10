package com.google.codelabs.mdc.kotlin.shrine

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.shr_login_fragment.*
import kotlinx.android.synthetic.main.shr_login_fragment.view.*
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

/**
 * Fragment representing the login screen for Shrine.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.shr_login_fragment, container, false)
        // Set an error if the password is less than 8 characters.
        view.next_button.setOnClickListener {
            if (!isUsernameValid(username_edit_text.text)) {
                username_text_input.error = getString(R.string.shr_error_username)
            }
            else if (!isPasswordValid(password_edit_text.text)) {
                password_text_input.error = getString(R.string.shr_error_password)
            } else {
                password_text_input.error = null // Clear the error
                username_text_input.error = null // Clear the error
//                (activity as NavigationHost).navigateTo(ProductGridFragment(), false) // Navigate to the next Fragment
                val navOptions = NavOptions.Builder()
                    .setEnterAnim(R.animator.fade_in)
                    .setExitAnim(R.animator.fade_out)
                    .build()
                (activity as NavigationHost).navigateTo(CultureListFragment(), false) // Navigate to the next Fragment
//                val action = actionLoginFragmentToProductGridFragment()
//                findNavController().navigate(action)
            }
        }

        // Clear the error once more than 8 characters are typed.
        view.password_edit_text.setOnKeyListener { _, _, _ ->
            if (isPasswordValid(password_edit_text.text)) {
                password_text_input.error = null //Clear the error
            }
            false
        }
        return view
    }

    /*
        In reality, this will have more complex logic including, but not limited to, actual
        authentication of the username and password.
     */
    private fun isPasswordValid(text: Editable?): Boolean {
//        return text != null && text.length >= 6
        return text.toString() == getString(R.string.password)
    }

    private fun isUsernameValid(text: Editable?): Boolean {
        return text != null && text.toString() == getString(R.string.username)
    }
}
