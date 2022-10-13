package com.example.watchchain.data.datamodels

data class Collector(
    val collectorName: String,
    val collectorLogo: String,
    val collectorTitleImg: String,
    val collectionName: String,
    val collection: List<Nft>
    )
