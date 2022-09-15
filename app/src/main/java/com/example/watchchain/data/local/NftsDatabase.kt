package com.example.watchchain.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.watchchain.data.datamodels.Browser

@Database(entities = [Browser::class], version = 1)
abstract class NftsDatabase : RoomDatabase() {

    abstract val nftsDatabaseDao : NftsDatabaseDao
}

private lateinit var  INSANCE: NftsDatabase

fun getDatabase(context: Context): NftsDatabase {
    synchronized(NftsDatabase::class.java) {
        if (!::INSANCE.isInitialized) {
            INSANCE = Room.databaseBuilder(
                context.applicationContext,
                NftsDatabase::class.java,
                "nft_database"
            )
                .build()
        }
    }
    return INSANCE
}