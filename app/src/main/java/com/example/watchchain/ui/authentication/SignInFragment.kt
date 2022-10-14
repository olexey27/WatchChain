package com.example.watchchain.ui.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.watchchain.MainActivity
import com.example.watchchain.R
import com.example.watchchain.databinding.ActivityMainBinding
import com.example.watchchain.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as MainActivity).hidebottomBar()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_in, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.signUpButton.setOnClickListener {
            findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToCreateAccountFragment())
        }


        binding.signInButton.setOnClickListener {
            val email = binding.signInEmailEdit.text.toString()
            val password = binding.signInPassword.text.toString()

            if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
                viewModel.login(email, password)
            }
        }

        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                    findNavController().navigate(R.id.browserFragment)
                }
            }
        )
    }
}