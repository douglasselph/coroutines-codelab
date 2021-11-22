package com.dugsolutions.coroutinesmvc.common.di

import com.dugsolutions.coroutinesmvc.MyApplication
import com.dugsolutions.coroutinesmvc.common.base.BaseActivity
import com.dugsolutions.coroutinesmvc.common.wrapper.Binder
import com.dugsolutions.coroutinesmvc.common.wrapper.BinderImpl
import com.dugsolutions.coroutinesmvc.titleDisplay.repo.TitleRepository

open class ComponentActivityRoot(
    val activity: BaseActivity
) {

    private val myapp: MyApplication by lazy {
        activity.applicationContext as MyApplication
    }

    private val componentAppRoot: ComponentAppRoot by lazy {
        myapp.componentRoot
    }

    // region public

    val binder: Binder by lazy {
        BinderImpl(activity.lifecycle)
    }

    // endregion public

}