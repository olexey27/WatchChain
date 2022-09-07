package com.example.watchchain.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.watchchain.R
import com.example.watchchain.data.datamodels.Collector
import com.example.watchchain.data.datamodels.Nft

class Repository {

    private val _nft = MutableLiveData<List<Nft>>()
    val nft: LiveData<List<Nft>>
    get() = _nft

    val collectors = listOf(
        Collector(
            R.drawable.titel,
            R.drawable.logo,
            R.string.collector1,
            "#1",
            74.3,
            "9477",
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.logo
        ),
    )

    fun loadNft() {
        _nft.value = listOf(
            Nft(R.drawable.img, "#1", "9477", 74.4, R.string.collector1),
        )
    }
}