package com.dugsolutions.coroutinesmvc.titleDisplay.di

import android.app.Activity
import android.view.LayoutInflater
import com.dugsolutions.coroutinesmvc.titleDisplay.TitleDisplayViewMvc
import com.dugsolutions.coroutinesmvc.titleDisplay.TitleDisplayViewMvcImpl

class TitlesViewMvcFactory(
    private val activity: Activity
) {

    private val layoutInflater: LayoutInflater by lazy {
        LayoutInflater.from(activity)
    }

    fun allocMainViewMvc(): TitleDisplayViewMvc = TitleDisplayViewMvcImpl(layoutInflater)

}