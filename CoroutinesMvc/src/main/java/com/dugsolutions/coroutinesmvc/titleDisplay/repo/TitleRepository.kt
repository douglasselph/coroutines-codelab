package com.dugsolutions.coroutinesmvc.titleDisplay.repo

import kotlinx.coroutines.flow.StateFlow

typealias TitleFlow = StateFlow<String>

interface TitleRepository {

    class TitleRefreshError(message: String, cause: Throwable) : Throwable(message, cause)

    @Throws(TitleRefreshError::class)
    suspend fun acquireTitleFlow(): TitleFlow

    @Throws(TitleRefreshError::class)
    suspend fun acquireNextTitle()

}