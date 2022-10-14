package com.example.watchchain.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.watchchain.R
import com.example.watchchain.databinding.FragmentWalletBinding
import com.example.watchchain.ui.authentication.MainViewModel

class WalletFragment : Fragment() {

    private lateinit var binding: FragmentWalletBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_wallet, container, false)

        return binding.root
    }

}