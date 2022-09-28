package com.example.watchchain.data

import androidx.lifecycle.LiveData
import com.example.watchchain.data.datamodels.Nft
import com.example.watchchain.data.local.NftsDatabase
import com.example.watchchain.data.remote.NftApi

class Repository(private val nftApi: NftApi, private val database: NftsDatabase) {

    val nftList: LiveData<List<Nft>> = database.nftsDatabaseDao.getAll()

    suspend fun getNfts() {
        val newList = nftApi.retrofitService.getNfts()

        database.nftsDatabaseDao.deleteAll()

        database.nftsDatabaseDao.insertNfts(newList)
    }
}