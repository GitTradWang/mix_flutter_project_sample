package com.tradwang.fluttermodule

import androidx.annotation.CallSuper
import com.tradwang.basemodule.App

open class BoostApplication : App() {

    @CallSuper
    override fun onCreate() {
        super.onCreate()

        BoostManager.init(this)
    }
}