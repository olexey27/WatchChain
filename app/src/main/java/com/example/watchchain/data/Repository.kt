package com.example.watchchain.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.watchchain.data.datamodels.Collector
import com.example.watchchain.data.datamodels.Nft
import com.example.watchchain.data.local.NftsDatabase
import com.example.watchchain.data.remote.NftApi

class Repository(private val nftApi: NftApi) {

    //val collectorList: LiveData<List<Collector>>
    //= database.nftsDatabaseDao.getAll()

    private var _collectors = MutableLiveData<List<Collector>>()
    val collectors : LiveData<List<Collector>>
    get() = _collectors





    suspend fun getNfts() {
        val newList = nftApi.retrofitService.getNfts()

        //database.nftsDatabaseDao.deleteAll()

        //database.nftsDatabaseDao.insertNfts(newList)
    }
}