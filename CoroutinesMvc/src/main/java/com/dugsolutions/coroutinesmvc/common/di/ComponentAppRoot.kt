package com.dugsolutions.coroutinesmvc.common.di

import com.dugsolutions.coroutinesmvc.MyApplication
import com.dugsolutions.coroutinesmvc.titleDisplay.di.TitlesComponentAppRoot

class ComponentAppRoot(private val app: MyApplication) {

    val titlesComponentRoot: TitlesComponentAppRoot by lazy {
        TitlesComponentAppRoot(app)
    }

}