package com.dugsolutions.coroutinesmvc.titleDisplay.di

import com.dugsolutions.coroutinesmvc.common.base.BaseActivity
import com.dugsolutions.coroutinesmvc.common.di.ComponentActivityRoot
import com.dugsolutions.coroutinesmvc.common.di.ComponentAppRoot
import com.dugsolutions.coroutinesmvc.common.wrapper.Binder
import com.dugsolutions.coroutinesmvc.common.wrapper.BinderImpl
import com.dugsolutions.coroutinesmvc.titleDisplay.repo.TitleRepository

class TitlesComponentActivityRoot(
    activity: BaseActivity
) : ComponentActivityRoot(activity) {

}