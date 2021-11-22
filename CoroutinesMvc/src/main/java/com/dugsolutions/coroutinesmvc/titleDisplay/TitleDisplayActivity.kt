package com.dugsolutions.coroutinesmvc.titleDisplay

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dugsolutions.coroutinesmvc.MyApplication
import com.dugsolutions.coroutinesmvc.common.base.BaseActivity
import com.dugsolutions.coroutinesmvc.titleDisplay.data.TitleUIElements
import com.dugsolutions.coroutinesmvc.titleDisplay.di.TitlesComponentActivityRoot
import com.dugsolutions.coroutinesmvc.titleDisplay.di.TitlesComponentAppRoot
import com.dugsolutions.coroutinesmvc.titleDisplay.di.TitlesControllerFactory
import com.dugsolutions.coroutinesmvc.titleDisplay.di.TitlesViewMvcFactory

class TitleDisplayActivity : BaseActivity() {

    private val componentRoot: TitlesComponentActivityRoot by lazy { TitlesComponentActivityRoot(this, appRoot) }
    private val controllerFactory: TitlesControllerFactory by lazy { TitlesControllerFactory(componentRoot) }
    private val viewMvcFactory: TitlesViewMvcFactory by lazy { TitlesViewMvcFactory(this) }
    private lateinit var titleDisplayController: TitleDisplayController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewMvc = viewMvcFactory.allocMainViewMvc()
        setContentView(viewMvc.rootView)
        titleDisplayController = controllerFactory.allocMainController(viewMvc)
        val viewModel = ViewModelProvider(this)[TitleUIElements::class.java]
    }

}