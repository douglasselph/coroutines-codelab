package com.dugsolutions.coroutinesmvc.titleDisplay

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.dugsolutions.coroutinesmvc.common.CoroutineJob
import com.dugsolutions.coroutinesmvc.common.wrapper.Binder
import com.dugsolutions.coroutinesmvc.titleDisplay.data.TitleUIElements
import com.dugsolutions.coroutinesmvc.titleDisplay.repo.TitleRepository
import kotlinx.coroutines.flow.collect

class TitleDisplayController(
    binder: Binder,
    private val viewMvc: TitleDisplayViewMvc,
    private val titleRepository: TitleRepository,
    private val titleUIElements: TitleUIElements
) : DefaultLifecycleObserver,
    TitleDisplayViewMvc.Listener {

    private val scope = CoroutineJob()

    // region LifecycleEventObserver

    init {
        binder.bindObserver(this)
    }

    override fun onStart(owner: LifecycleOwner) {
        viewMvc.registerListener(this)
        scope.launch {
            try {
                viewMvc.spinnerVisible = true
                titleRepository.acquireTitleFlow().collect { viewMvc.title = it }
            } catch (ex: TitleRepository.TitleRefreshError) {
                showError(ex.message)
            } finally {
                viewMvc.spinnerVisible = false
            }
        }
    }

    override fun onStop(owner: LifecycleOwner) {
        viewMvc.unregisterListener(this)
        scope.dispose()
    }

    // endregion Lifecycle

    // region MainViewMvc.Listener

    override fun onMainViewClicked() {
        scope.launch {
            titleRepository.acquireNextTitle()
            advanceTaps()
        }
    }

    // endregion MainViewMvc.Listener

    private fun advanceTaps() {
        taps++
        showTaps()
    }

    private fun showTaps() {
        viewMvc.taps = "$taps taps"
    }

    private fun showError(message: String?) {
        message?.let { viewMvc.showSnackMessage(message) }
    }

}