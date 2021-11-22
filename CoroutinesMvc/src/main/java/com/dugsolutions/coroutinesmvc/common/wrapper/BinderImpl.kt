package com.dugsolutions.coroutinesmvc.common.wrapper

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import com.dugsolutions.coroutinesmvc.common.wrapper.Binder

class BinderImpl(private val lifecycle: Lifecycle) : Binder {

    override fun bindObserver(observer: LifecycleObserver) {
        lifecycle.addObserver(observer)
    }

}