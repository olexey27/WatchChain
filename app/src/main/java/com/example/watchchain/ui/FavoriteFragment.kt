package com.example.watchchain.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.watchchain.adapter.CollectorAdapter
import com.example.watchchain.databinding.FragmentFavoriteBinding
import com.example.watchchain.ui.authentication.MainViewModel


class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.favoriteNft.observe(
            viewLifecycleOwner
        ) {
            binding.recyclerView.adapter = CollectorAdapter()
        }
    }*/
}