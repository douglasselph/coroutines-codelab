package com.dugsolutions.coroutinesmvc.common.observable

import android.content.Context
import android.view.View

abstract class ViewMvcImpl : ViewMvc {

    abstract override val rootView: View

    protected fun <T : View> findViewById(id: Int): T {
        return rootView.findViewById(id)
    }

    protected fun <T : View> findViewByIdNullable(id: Int): T? {
        return rootView.findViewById(id)
    }

    protected val context: Context
        get() = rootView.context

}
