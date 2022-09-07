package com.example.watchchain.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.watchchain.data.datamodels.Collector

@Dao
interface NftsDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(nft: List<Collector>)

    @androidx.room.Query("SELECT * FROM Nfts")
    fun getAll(): LiveData<List<Collector>>

}