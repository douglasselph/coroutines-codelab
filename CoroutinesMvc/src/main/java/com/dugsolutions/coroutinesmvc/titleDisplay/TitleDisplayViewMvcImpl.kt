package com.dugsolutions.coroutinesmvc.titleDisplay

import android.view.LayoutInflater
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.dugsolutions.coroutinesmvc.R
import com.dugsolutions.coroutinesmvc.common.observable.ObservableViewMvcImpl
import com.google.android.material.snackbar.Snackbar

class TitleDisplayViewMvcImpl(
    layoutInflater: LayoutInflater
) : ObservableViewMvcImpl<TitleDisplayViewMvc.Listener>(),
    TitleDisplayViewMvc {

    override val rootView: View = layoutInflater.inflate(R.layout.activity_title_display, null, false)

    private val titleView: TextView = findViewById(R.id.title)
    private val tapsView: TextView = findViewById(R.id.taps)
    private val spinnerView: ProgressBar = findViewById(R.id.spinner)

    init {
        rootView.setOnClickListener { listeners.forEach { it.onMainViewClicked() } }
    }

    // region MainViewMvc

    override var title: String
        get() = titleView.text.toString()
        set(value) {
            titleView.text = value
        }

    override var taps: String
        get() = tapsView.text.toString()
        set(value) {
            tapsView.text = value
        }

    override var spinnerVisible: Boolean
        get() = spinnerView.visibility == View.VISIBLE
        set(value) {
            spinnerView.visibility = if (value) View.VISIBLE else View.GONE
        }

    override fun showSnackMessage(text: String) {
        Snackbar.make(rootView, text, Snackbar.LENGTH_SHORT).show()
    }

    // endregion MainViewMvc

}