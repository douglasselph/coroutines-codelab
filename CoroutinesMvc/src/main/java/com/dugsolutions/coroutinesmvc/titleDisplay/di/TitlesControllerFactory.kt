package com.dugsolutions.coroutinesmvc.titleDisplay.di

import androidx.lifecycle.ViewModelProvider
import com.dugsolutions.coroutinesmvc.common.di.ComponentActivityRoot
import com.dugsolutions.coroutinesmvc.titleDisplay.TitleDisplayController
import com.dugsolutions.coroutinesmvc.titleDisplay.TitleDisplayViewMvc
import com.dugsolutions.coroutinesmvc.titleDisplay.data.TitleUIElements

class TitlesControllerFactory(
    private val componentRoot: TitlesComponentActivityRoot
) {
    val titleUIElements = ViewModelProvider(componentRoot.activity)[TitleUIElements::class.java]

    fun allocMainController(viewMvc: TitleDisplayViewMvc): TitleDisplayController =
        with(componentRoot) {
            TitleDisplayController(
                binder,
                viewMvc,
                titleUIElements
            )
        }

}