package com.example.watchchain.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.watchchain.databinding.FragmentCollectorBinding

class CollectorFragment : Fragment() {

    private lateinit var binding: FragmentCollectorBinding

    private val viewModel: MainViewModel by activityViewModels()

}