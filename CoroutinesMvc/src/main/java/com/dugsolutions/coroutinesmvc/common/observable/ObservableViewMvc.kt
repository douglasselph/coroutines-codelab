package com.dugsolutions.coroutinesmvc.common.observable

interface ObservableViewMvc<ListenerType> : ViewMvc {

    val numListeners: Int

    fun registerListener(listener: ListenerType)

    fun unregisterListener(listener: ListenerType)

    fun unregisterListeners()
}
