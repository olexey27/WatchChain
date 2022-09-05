package com.example.watchchain.ui.authentication

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.watchchain.R
import com.example.watchchain.databinding.SignInBinding
import com.example.watchchain.ui.MainViewModel

class SignInFragment : Fragment() {

    private lateinit var binding: SignInBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.sign_in, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signUpTextButton.setOnClickListener {
            findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToCreateAccountFragment())
        }


        binding.loginButton.setOnClickListener {
            val email = binding.emailAddressEdit.text.toString()
            val password = binding.passwordText.text.toString()

            if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
                viewModel.signUp(email, password)
            }
        }

        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                  //  Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                    AlertDialog.Builder(requireContext())
                        .create()
                        .show()
                }
            }
        )
        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                    findNavController().navigate(R.id.mainFragment)
                }
            }
        )
    }
}