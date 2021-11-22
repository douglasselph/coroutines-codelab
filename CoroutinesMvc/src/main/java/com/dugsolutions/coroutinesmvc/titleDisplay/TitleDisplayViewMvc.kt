package com.dugsolutions.coroutinesmvc.titleDisplay

import com.dugsolutions.coroutinesmvc.common.observable.ObservableViewMvc

interface TitleDisplayViewMvc : ObservableViewMvc<TitleDisplayViewMvc.Listener> {

    interface Listener {
        fun onMainViewClicked()
    }

    var title: String
    var taps: String
    var spinnerVisible: Boolean
    fun showSnackMessage(text: String)

}