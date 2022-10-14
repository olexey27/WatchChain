package com.example.watchchain.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.watchchain.R
import com.example.watchchain.databinding.FragmentNftBinding
import com.example.watchchain.ui.authentication.MainViewModel

private const val TAG = "NftFragment"

class NftFragment : Fragment() {

    private lateinit var binding: FragmentNftBinding

    private val viewModel: MainViewModel by activityViewModels()

    var nft = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { nft = "nftName" }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNftBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }
}