package com.example.watchchain.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import coil.load
import com.example.watchchain.R
import com.example.watchchain.adapter.CollectorAdapter
import com.example.watchchain.databinding.FragmentCollectorBinding
import com.example.watchchain.ui.authentication.MainViewModel

class CollectorFragment : Fragment() {

    private lateinit var binding: FragmentCollectorBinding

    private val viewModel: MainViewModel by activityViewModels()

    var collector = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { collector = "collectorName" }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCollectorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.nfts.observe(
            viewLifecycleOwner,
            Observer {
                list ->
                val collection = list.find { it.collectorName == collector }
                //binding.nftsRecycler.adapter = CollectorAdapter(collection)
                binding.collectionName.text = collection!!.collectionName

                val imgUri = collection.collectorLogo.toUri().buildUpon().scheme("http").build()
                binding.profilPicture.load(imgUri)

                val imgUri1 = collection.collectorTitleImg.toUri().buildUpon().scheme("http").build()
                binding.titleBackground.load(imgUri1)



            }
        )
    }
}