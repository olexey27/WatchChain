package com.example.watchchain.ui.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.watchchain.R
import com.example.watchchain.databinding.FragmentCreateAccountBinding

/**
 * SignUpFragment enthält das UI um einen neuen User zu registrieren
 */
class CreateAccountFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    private  lateinit var binding: FragmentCreateAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_account, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInTextButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.createAccountButton.setOnClickListener {
            singUp()
        }

        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                    findNavController().navigate(R.id.browserFragment)
                }
            }
        )
        binding.googleImageButton.setOnClickListener() {
            Toast.makeText(context,R.string.error, Toast.LENGTH_LONG).show()
        }
        binding.appleImageButton.setOnClickListener() {
            Toast.makeText(context,R.string.error, Toast.LENGTH_LONG).show()
        }
        binding.facebookImageButton.setOnClickListener() {
            Toast.makeText(context,R.string.error, Toast.LENGTH_LONG).show()
        }
    }

    private fun singUp() {
        val email = binding.signInEmailEdit.text.toString()
        val password1 = binding.passwordEdit.text.toString()
        val password2 = binding.confirmPasswordEdit.text.toString()


        if (!email.isNullOrEmpty() && !password1.isNullOrEmpty() && password1 == password2) {
            viewModel.signUp(email, password1)
        }
    }
}