package com.dugsolutions.coroutinesmvc.titleDisplay.di

import com.dugsolutions.coroutinesmvc.MyApplication
import com.dugsolutions.coroutinesmvc.titleDisplay.repo.TitleRepository
import com.dugsolutions.coroutinesmvc.titleDisplay.repo.TitleRepositoryImpl
import com.dugsolutions.coroutinesmvc.titleDisplay.repo.dao.TitlesDatabase
import com.dugsolutions.coroutinesmvc.titleDisplay.repo.dao.TitlesDatabaseImpl
import com.dugsolutions.coroutinesmvc.titleDisplay.repo.network.TitlesNetwork
import com.dugsolutions.coroutinesmvc.titleDisplay.repo.network.TitlesNetworkImpl

class TitlesComponentAppRoot(private val app: MyApplication) {

    val titlesDatabase: TitlesDatabase by lazy {
        TitlesDatabaseImpl(app)
    }

    val titlesNetwork: TitlesNetwork by lazy {
        TitlesNetworkImpl()
    }

    val titleRepository: TitleRepository by lazy {
        TitleRepositoryImpl(
            titlesNetwork,
            titlesDatabase
        )
    }

}