package com.dugsolutions.coroutinesmvc.common.observable

import java.util.*

abstract class BaseObservableImpl<ListenerType> : BaseObservable<ListenerType> {

    private val _listeners = HashSet<ListenerType>()

    protected val listeners: Set<ListenerType>
        @Synchronized
        get() = Collections.unmodifiableSet(HashSet(_listeners))

    @Synchronized
    override fun registerListener(listener: ListenerType) {
        _listeners.remove(listener)
        _listeners.add(listener)
    }

    @Synchronized
    override fun unregisterListener(listener: ListenerType) {
        _listeners.remove(listener)
    }
}
