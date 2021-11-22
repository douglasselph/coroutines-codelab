package com.dugsolutions.coroutinesmvc.titleDisplay.repo

import com.dugsolutions.coroutinesmvc.titleDisplay.data.Title
import com.dugsolutions.coroutinesmvc.titleDisplay.repo.TitleRepository.TitleRefreshError
import com.dugsolutions.coroutinesmvc.titleDisplay.repo.dao.TitlesDatabase
import com.dugsolutions.coroutinesmvc.titleDisplay.repo.network.TitlesNetwork
import kotlinx.coroutines.flow.MutableStateFlow

class TitleRepositoryImpl(
    private val network: TitlesNetwork,
    private val database: TitlesDatabase
) : TitleRepository {

    // region TitleRepository

    @Throws(TitleRefreshError::class)
    override suspend fun acquireTitleFlow(): TitleFlow {
        if (titleFlow.value.isEmpty()) {
            acquireNextTitle()
        }
        return titleFlow
    }

    @Throws(TitleRefreshError::class)
    override suspend fun acquireNextTitle() {
        try {
            val title = network.fetchNextTitle()
            database.insertTitle(Title(title))
            titleFlow.value = title
        } catch (error: Throwable) {
            throw TitleRefreshError("Unable to refresh title", error)
        }
    }

    // endregion TitleRepository

    private val titleFlow: MutableStateFlow<String> by lazy {
        MutableStateFlow(database.title?.title ?: "")
    }

}