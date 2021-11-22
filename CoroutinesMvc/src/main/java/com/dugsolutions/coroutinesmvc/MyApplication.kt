package com.dugsolutions.coroutinesmvc

import android.app.Application
import com.dugsolutions.coroutinesmvc.common.di.ComponentAppRoot

class MyApplication : Application() {

    val componentRoot: ComponentAppRoot by lazy {
        ComponentAppRoot(this)
    }

    override fun onCreate() {
        super.onCreate()
    }
}