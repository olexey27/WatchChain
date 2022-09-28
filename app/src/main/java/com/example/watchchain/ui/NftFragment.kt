package com.example.watchchain.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.watchchain.databinding.FragmentNftBinding
import com.example.watchchain.ui.authentication.MainViewModel

class NftFragment : Fragment() {

    private lateinit var binding: FragmentNftBinding

    private val viewModel: MainViewModel by activityViewModels()

}