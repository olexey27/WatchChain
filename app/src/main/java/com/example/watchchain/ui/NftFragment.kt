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

    private var nftid = ""


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNftBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val nft = viewModel.nfts.value?.find { it.collectorName == nftid }

        if (nft != null) {
            Log.d(TAG,"found NFT")

            val imgUri = nft.nftImage.toUri().buildUpon().scheme("http").build()
            binding.detailCardView.load(imgUri) {
                placeholder(R.drawable.img3683)
            }
        }
    }
}