package com.dugsolutions.coroutinesmvc.titleDisplay.repo.network

interface TitlesNetwork {

    suspend fun fetchNextTitle(): String

}