package com.example.watchchain.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.watchchain.R
import com.example.watchchain.adapter.BrowserAdapter
import com.example.watchchain.adapter.CollectorAdapter
import com.example.watchchain.databinding.FragmentCollectorBinding
import com.example.watchchain.ui.authentication.MainViewModel

class CollectorFragment : Fragment() {

    private lateinit var binding: FragmentCollectorBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_collector, container, false)

        return binding.root
    }

    //override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
     //   binding.nftsRecycler.adapter = CollectorAdapter()
    //}

}