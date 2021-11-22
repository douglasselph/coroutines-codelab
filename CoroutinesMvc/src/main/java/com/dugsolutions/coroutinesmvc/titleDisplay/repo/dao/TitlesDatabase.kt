package com.dugsolutions.coroutinesmvc.titleDisplay.repo.dao

import com.dugsolutions.coroutinesmvc.titleDisplay.data.Title

interface TitlesDatabase {

    suspend fun insertTitle(title: Title)
    val title: Title?

}