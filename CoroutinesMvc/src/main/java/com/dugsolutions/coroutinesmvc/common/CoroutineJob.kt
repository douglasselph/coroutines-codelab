package com.dugsolutions.coroutinesmvc.common

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CoroutineJob(
        private val dispatcher: CoroutineContext = Dispatchers.Main
) {

    companion object {
        private var fixedIODispatcher: Boolean = false
        /**
         * Fix bug in coroutines where they limit the max number of parallel jobs for some reason.
         * This only creates problems, and does not otherwise help anything.
         */
        private fun fixIODispatcher() {
            if (!fixedIODispatcher) {
                System.setProperty(IO_PARALLELISM_PROPERTY_NAME, Int.MAX_VALUE.toString())
                fixedIODispatcher = true
            }
        }
    }

    private var scope: CoroutineScope? = null

    init {
        fixIODispatcher()
    }

    // region public

    val isRunning: Boolean
        get() = scope != null

    fun launch(block: suspend CoroutineScope.() -> Unit) {
        if (scope == null) {
            scope = CoroutineScope(dispatcher)
        }
        scope?.launch {
            block()
        }
    }

    fun dispose() {
        scope?.cancel()
        scope = null
    }

    // endregion public

}
