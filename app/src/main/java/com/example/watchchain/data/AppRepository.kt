package com.example.watchchain.data

import androidx.lifecycle.LiveData
import com.example.watchchain.data.datamodels.Browser
import com.example.watchchain.data.local.NftsDatabase
import com.example.watchchain.data.remote.NftApi

const val TAG = "AppRepository"

class AppRepository (private val api: NftApi, private val database: NftsDatabase) {

    val browser: LiveData<List<Browser>> = database.nftsDatabaseDao.getAll()

    suspend fun getNft() {
    }
}