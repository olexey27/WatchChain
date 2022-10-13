package com.example.watchchain.data.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Nft(
    val nftImage: String,
    val nftName: String,
    val nftPrice: String
    )