package com.dugsolutions.coroutinesmvc.titleDisplay.repo.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class TitlesNetworkImpl: TitlesNetwork {

    // region TitlesNetwork

    override suspend fun fetchNextTitle(): String = service.fetchNextTitle()

    // endregion TitlesNetwork

    private interface Network {
        @GET("next_title.json")
        suspend fun fetchNextTitle(): String
    }

    private val service: Network by lazy {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(SkipNetworkInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(Network::class.java)
    }

}