package com.example.watchchain.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.watchchain.data.datamodels.Nft

@Dao
interface NftsDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNfts(nfts: List<Nft>)

    @Query("SELECT * from Nft")
    fun getAll(): LiveData<List<Nft>>

    @Query("DELETE from Nft")
    suspend fun deleteAll()
}