package com.dugsolutions.coroutinesmvc.common.base

import androidx.appcompat.app.AppCompatActivity
import com.dugsolutions.coroutinesmvc.MyApplication
import com.dugsolutions.coroutinesmvc.common.di.ComponentActivityRoot
import com.dugsolutions.coroutinesmvc.common.di.ComponentAppRoot

open class BaseActivity : AppCompatActivity() {

    protected val componentAppRoot: ComponentAppRoot
        get() = (applicationContext as MyApplication).componentRoot

}