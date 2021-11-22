package com.dugsolutions.coroutinesmvc.common.wrapper

import androidx.lifecycle.LifecycleObserver

interface Binder {

    fun bindObserver(observer: LifecycleObserver)

}