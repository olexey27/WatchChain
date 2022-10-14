package com.example.watchchain.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.watchchain.R
import com.example.watchchain.databinding.FragmentProfileBinding
import com.example.watchchain.ui.authentication.MainViewModel


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.shareProfileB.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "Check my Profil")
            intent.type = "text/plain"
            val shareIntent = Intent.createChooser(intent, null)
            startActivity(shareIntent)
        }
        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                if (it == null) {
                    findNavController().navigate(R.id.signInFragment)
                }
            }
        )

        binding.logOut.setOnClickListener {
            viewModel.logout()
        }
    }
}