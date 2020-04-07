package com.tradwang.fluttermodule

import android.app.Application
import android.content.Context
import android.util.Log
import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.interfaces.INativeRouter
import io.flutter.embedding.android.FlutterView

object BoostManager : INativeRouter, FlutterBoost.BoostLifecycleListener {

    @JvmStatic
    fun init(application: Application) {
        val platform = FlutterBoost.ConfigBuilder(application, this).isDebug(true).whenEngineStart(FlutterBoost.ConfigBuilder.ANY_ACTIVITY_CREATED).renderMode(FlutterView.RenderMode.texture)
            .lifecycleListener(this)
            .build()

        FlutterBoost.instance().init(platform)
    }

    override fun openContainer(context: Context, path: String?, params: MutableMap<String, Any>?, requestCode: Int, exts: MutableMap<String, Any>?) {
        PageRouter.openPageByUrl(context, path, params = params, requestCode = requestCode, exts = exts)
    }

    override fun beforeCreateEngine() {
        Log.d(BoostManager::class.java.simpleName, "beforeCreateEngine")
    }

    override fun onEngineCreated() {
        Log.d(BoostManager::class.java.simpleName, "onEngineCreated")
    }

    override fun onPluginsRegistered() {
        Log.d(BoostManager::class.java.simpleName, "onPluginsRegistered")
    }

    override fun onEngineDestroy() {
        Log.d(BoostManager::class.java.simpleName, "onEngineDestroy")
    }
}