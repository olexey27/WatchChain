package com.example.watchchain.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import coil.load
import com.example.watchchain.R
import com.example.watchchain.databinding.FragmentNftBinding
import com.example.watchchain.ui.authentication.MainViewModel


class NftFragment : Fragment() {

    private lateinit var binding: FragmentNftBinding

    private val viewModel: MainViewModel by activityViewModels()

    var nftName = ""
    var collectionName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nftName = it.getString("nftName").toString()
            collectionName = it.getString("collectionName").toString()
            }
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
        super.onViewCreated(view, savedInstanceState)

        viewModel.nfts.observe(
            viewLifecycleOwner,
            Observer { list ->
                val collection = list.find { it.collectionName == collectionName }
                if (collection != null) {
                    val nft = collection.collection.find { it.nftName == nftName }
                    if (nft != null) {
                        binding.nftName.text = nft.nftName
                        binding.priceText.text = nft.nftPrice
                        val imgUri = nft.nftImage.toUri().buildUpon().scheme("https").build()
                        binding.nftImage.load(imgUri)
                    }
                }
            }
        )
        binding.buyButton.setOnClickListener() {
            Toast.makeText(context,R.string.buy_nft,Toast.LENGTH_LONG).show()
        }
    }
}