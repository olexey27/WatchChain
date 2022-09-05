package com.example.watchchain.data

import androidx.lifecycle.LiveData
import com.example.watchchain.data.datamodels.Nfts
import com.example.watchchain.data.local.NftsDatabase
import com.example.watchchain.data.remote.NftApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

const val TAG = "AppRepository"

class AppRepository (private val api: NftApi, private val database: NftsDatabase) {

    val nfts: LiveData<List<Nfts>> = database.nftsDatabaseDao.getAll()

    suspend fun getNft() {
        withContext(Dispatchers.IO) {
            val newNftsList = api.retrofitService.getNftsList().nft
            database.nftsDatabaseDao.insertAll(newNftsList)
        }
    }
}