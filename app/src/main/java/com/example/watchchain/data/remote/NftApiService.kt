package com.example.watchchain.data.remote

import com.example.watchchain.data.datamodels.NftsList
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://deep-index.moralis.io/api/v2/{address}/nft"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface NftApiService {

    @GET()
    suspend fun getNftsList(): NftsList
}

object NftApi {
    val retrofitService: NftApiService by lazy { retrofit.create(NftApiService::class.java)}
}