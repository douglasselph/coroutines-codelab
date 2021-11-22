package com.dugsolutions.coroutinesmvc.common.observable

interface BaseObservable<ListenerType> {

    fun registerListener(listener: ListenerType)

    fun unregisterListener(listener: ListenerType)

}