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
            R.string.collection1,
            R.string.collector1,
            R.drawable.img3683,
            R.drawable.img8922,
            R.drawable.img9611,
            R.drawable.logo
        ),
        Browser(
            R.string.collection2,
            R.string.collector2,
            R.drawable.img10602,
            R.drawable.img26170,
            R.drawable.img24262,
            R.drawable.mutantapeyachtclublogo
        ),
        Browser(
            R.string.collection3,
            R.string.collector3,
            R.drawable.clonex18404,
            R.drawable.clonex16919,
            R.drawable.clonex12308,
            R.drawable.clonexlogo
        ),
        Browser(
            R.string.collection4,
            R.string.collector4,
            R.drawable.sora_decayed,
            R.drawable.scapalio,
            R.drawable.murmur,
            R.drawable.cyberbrokerslogo
        )
    )

    fun loadNft() {
        _nft.value = listOf(
            Nft(R.string.collector1,R.drawable.logo,R.drawable.titel,R.drawable.img3683,R.string.nft1,R.string.price1,R.string.collector1),
            Nft(R.string.collector1,R.drawable.logo,R.drawable.titel,R.drawable.img8922,R.string.nft2,R.string.price2,R.string.collector1),
            Nft(R.string.collector1,R.drawable.logo,R.drawable.titel,R.drawable.img9611,R.string.nft3,R.string.price3,R.string.collector1),
            Nft(R.string.collector1,R.drawable.logo,R.drawable.titel,R.drawable.img330,R.string.nft4,R.string.price4,R.string.collector1),
            Nft(R.string.collector1,R.drawable.logo,R.drawable.titel,R.drawable.img4591,R.string.nft5,R.string.price5,R.string.collector1),
            Nft(R.string.collector1,R.drawable.logo,R.drawable.titel,R.drawable.img1570,R.string.nft6,R.string.price6,R.string.collector1),
            Nft(R.string.collector1,R.drawable.logo,R.drawable.titel,R.drawable.img6140,R.string.nft7,R.string.price7,R.string.collector1),
            Nft(R.string.collector1,R.drawable.logo,R.drawable.titel,R.drawable.img622,R.string.nft8,R.string.price8,R.string.collector1),
            Nft(R.string.collector1,R.drawable.logo,R.drawable.titel,R.drawable.img3651,R.string.nft9,R.string.price9,R.string.collector1),
            Nft(R.string.collector1,R.drawable.logo,R.drawable.titel,R.drawable.img4704,R.string.nft10,R.string.price10,R.string.collector1),

            Nft(R.string.collector2,R.drawable.mutantapeyachtclublogo,R.drawable.mutantapeyachtclubtitle,R.drawable.img10602,R.string.nft11,R.string.price11,R.string.collector2),
            Nft(R.string.collector2,R.drawable.mutantapeyachtclublogo,R.drawable.mutantapeyachtclubtitle,R.drawable.img26170,R.string.nft12,R.string.price12,R.string.collector2),
            Nft(R.string.collector2,R.drawable.mutantapeyachtclublogo,R.drawable.mutantapeyachtclubtitle,R.drawable.img24262,R.string.nft13,R.string.price13,R.string.collector2),
            Nft(R.string.collector2,R.drawable.mutantapeyachtclublogo,R.drawable.mutantapeyachtclubtitle,R.drawable.img2761,R.string.nft14,R.string.price14,R.string.collector2),
            Nft(R.string.collector2,R.drawable.mutantapeyachtclublogo,R.drawable.mutantapeyachtclubtitle,R.drawable.img790,R.string.nft15,R.string.price15,R.string.collector2),
            Nft(R.string.collector2,R.drawable.mutantapeyachtclublogo,R.drawable.mutantapeyachtclubtitle,R.drawable.img26958,R.string.nft16,R.string.price16,R.string.collector2),
            Nft(R.string.collector2,R.drawable.mutantapeyachtclublogo,R.drawable.mutantapeyachtclubtitle,R.drawable.img4852,R.string.nft17,R.string.price17,R.string.collector2),
            Nft(R.string.collector2,R.drawable.mutantapeyachtclublogo,R.drawable.mutantapeyachtclubtitle,R.drawable.img4777,R.string.nft18,R.string.price18,R.string.collector2),
            Nft(R.string.collector2,R.drawable.mutantapeyachtclublogo,R.drawable.mutantapeyachtclubtitle,R.drawable.img12200,R.string.nft19,R.string.price19,R.string.collector2),
            Nft(R.string.collector2,R.drawable.mutantapeyachtclublogo,R.drawable.mutantapeyachtclubtitle,R.drawable.img7642,R.string.nft20,R.string.price20,R.string.collector2),

            Nft(R.string.collector3,R.drawable.clonexlogo,R.drawable.clonex_title_img,R.drawable.clonex18404,R.string.nft21,R.string.price21,R.string.collector3),
            Nft(R.string.collector3,R.drawable.clonexlogo,R.drawable.clonex_title_img,R.drawable.clonex12308,R.string.nft22,R.string.price22,R.string.collector3),
            Nft(R.string.collector3,R.drawable.clonexlogo,R.drawable.clonex_title_img,R.drawable.clonex16919,R.string.nft23,R.string.price23,R.string.collector3),
            Nft(R.string.collector3,R.drawable.clonexlogo,R.drawable.clonex_title_img,R.drawable.clonex8098,R.string.nft24,R.string.price24,R.string.collector3),
            Nft(R.string.collector3,R.drawable.clonexlogo,R.drawable.clonex_title_img,R.drawable.clonex10115,R.string.nft25,R.string.price25,R.string.collector3),
            Nft(R.string.collector3,R.drawable.clonexlogo,R.drawable.clonex_title_img,R.drawable.clonex19482,R.string.nft26,R.string.price26,R.string.collector3),
            Nft(R.string.collector3,R.drawable.clonexlogo,R.drawable.clonex_title_img,R.drawable.clonex18164,R.string.nft27,R.string.price27,R.string.collector3),
            Nft(R.string.collector3,R.drawable.clonexlogo,R.drawable.clonex_title_img,R.drawable.clonex6748,R.string.nft28,R.string.price28,R.string.collector3),
            Nft(R.string.collector3,R.drawable.clonexlogo,R.drawable.clonex_title_img,R.drawable.clonex18373,R.string.nft29,R.string.price29,R.string.collector3),
            Nft(R.string.collector3,R.drawable.clonexlogo,R.drawable.clonex_title_img,R.drawable.clonex2131,R.string.nft30,R.string.price30,R.string.collector3),

            Nft(R.string.collector4,R.drawable.cyberbrokerslogo,R.drawable.cyberbrokerstitle,R.drawable.sora_decayed,R.string.nft31,R.string.price31,R.string.collector4),
            Nft(R.string.collector4,R.drawable.cyberbrokerslogo,R.drawable.cyberbrokerstitle,R.drawable.scapalio,R.string.nft32,R.string.price32,R.string.collector4),
            Nft(R.string.collector4,R.drawable.cyberbrokerslogo,R.drawable.cyberbrokerstitle,R.drawable.murmur,R.string.nft33,R.string.price33,R.string.collector4),
            Nft(R.string.collector4,R.drawable.cyberbrokerslogo,R.drawable.cyberbrokerstitle,R.drawable.halios,R.string.nft34,R.string.price34,R.string.collector4),
            Nft(R.string.collector4,R.drawable.cyberbrokerslogo,R.drawable.cyberbrokerstitle,R.drawable.agilefrommorrison,R.string.nft35,R.string.price35,R.string.collector4),
            Nft(R.string.collector4,R.drawable.cyberbrokerslogo,R.drawable.cyberbrokerstitle,R.drawable.billiechaney,R.string.nft36,R.string.price36,R.string.collector4),
            Nft(R.string.collector4,R.drawable.cyberbrokerslogo,R.drawable.cyberbrokerstitle,R.drawable.rampart,R.string.nft37,R.string.price37,R.string.collector4),
            Nft(R.string.collector4,R.drawable.cyberbrokerslogo,R.drawable.cyberbrokerstitle,R.drawable.daggerseasoned,R.string.nft38,R.string.price38,R.string.collector4),
            Nft(R.string.collector4,R.drawable.cyberbrokerslogo,R.drawable.cyberbrokerstitle,R.drawable.eden,R.string.nft39,R.string.price39,R.string.collector4),
            Nft(R.string.collector4,R.drawable.cyberbrokerslogo,R.drawable.cyberbrokerstitle,R.drawable.xena_rustler,R.string.nft40,R.string.price40,R.string.collector4),
        )
    }
}