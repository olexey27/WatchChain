package com.example.watchchain.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.watchchain.R
import com.example.watchchain.data.datamodels.Browser
import com.example.watchchain.data.datamodels.Nft

class Repository {

    private val _nft = MutableLiveData<List<Nft>>()
    val nft: LiveData<List<Nft>>
    get() = _nft

    val browsers = listOf(
        Browser(
            R.drawable.titel,
            R.drawable.logo,
            R.string.collector1,
            R.string.price1,
            R.string.nft1,
            R.drawable.img3683,
            R.drawable.img8922,
            R.drawable.img9611,
            R.drawable.logo
        ),
        Browser(
            R.drawable.mutantapeyachtclubtitle,
            R.drawable.mutantapeyachtclublogo,
            R.string.collector2,
            R.string.price2,
            R.string.nft2,
            R.drawable.img10602,
            R.drawable.img26170,
            R.drawable.img24262,
            R.drawable.mutantapeyachtclublogo
        )
    )

    fun loadNft() {
        _nft.value = listOf(
            Nft(R.drawable.img3683, R.string.nft1, R.string.price1, R.string.collector1),
            Nft(R.drawable.img8922, R.string.nft2, R.string.price2, R.string.collector1),
            Nft(R.drawable.img9611, R.string.nft3, R.string.price3, R.string.collector1),
            Nft(R.drawable.img330, R.string.nft4, R.string.price4, R.string.collector1),
            Nft(R.drawable.img4591, R.string.nft5, R.string.price5, R.string.collector1),
            Nft(R.drawable.img1570, R.string.nft6, R.string.price6, R.string.collector1),
            Nft(R.drawable.img6140, R.string.nft7, R.string.price7, R.string.collector1),
            Nft(R.drawable.img622, R.string.nft8, R.string.price8, R.string.collector1),
            Nft(R.drawable.img3651, R.string.nft9, R.string.price9, R.string.collector1),
            Nft(R.drawable.img4704, R.string.nft10, R.string.price10, R.string.collector1),
        )
    }
}