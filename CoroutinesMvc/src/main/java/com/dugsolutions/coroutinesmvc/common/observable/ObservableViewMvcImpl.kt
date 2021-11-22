package com.dugsolutions.coroutinesmvc.common.observable
import java.util.*

/**
 * Thought: perhaps use java.util.Observable for added functionality.
 */
abstract class ObservableViewMvcImpl<ListenerType> : ViewMvcImpl(),
    ObservableViewMvc<ListenerType> {

    private val _listeners = HashSet<ListenerType>()

    protected val listeners: Set<ListenerType>
        get() = Collections.unmodifiableSet(_listeners)

    // region ObserverableViewMvc

    override val numListeners: Int
        get() = _listeners.size

    override fun registerListener(listener: ListenerType) {
        _listeners.remove(listener)
        _listeners.add(listener)
    }

    override fun unregisterListener(listener: ListenerType) {
        _listeners.remove(listener)
    }

    override fun unregisterListeners() {
        _listeners.clear()
    }

}
