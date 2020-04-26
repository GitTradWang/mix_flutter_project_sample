package com.tradwang.basemodule

import android.app.Application
import android.content.Context
import androidx.annotation.CallSuper
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter

open class App : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

    @CallSuper
    override fun onCreate() {
        super.onCreate()

        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }
}