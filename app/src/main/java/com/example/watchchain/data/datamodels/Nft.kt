package com.example.watchchain.data.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Nft(
    @PrimaryKey(autoGenerate = true)
    val collectorName: String,
    val collectorLogo: String,
    val collectorTitlePic: String,
    val nftImage: String,
    val nameNft: String,
    val price: Double,
    val collector: String,
    val collectionName: String,
    val idCollector: Long = 0,
    val nftImage1: String,
    val nftImage2: String,
    val nftImage3: String,
    val imageLogo: String
    )