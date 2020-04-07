package com.tradwang.fluttermodule

import android.app.Activity
import android.content.Context
import android.os.Parcelable
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter
import com.idlefish.flutterboost.containers.BoostFlutterActivity
import java.io.Serializable

object PageRouter {

    @JvmStatic
    fun openPageByUrl(context: Context, path: String?, params: Map<String, Any>? = null, requestCode: Int = 0, exts: Map<String, *>? = null): Boolean {

        path ?: return false

        Log.w(PageRouter::class.java.simpleName, "context: $context ,url: $path ,urlParams: $params ,requestCode: $requestCode ,exts: $exts")

        if (path.startsWith(FLUTTER_PAGE_SUFFIX)) {
            val intent = BoostFlutterActivity.withNewEngine().url(path).params(params.safe()).backgroundMode(BoostFlutterActivity.BackgroundMode.opaque).build(context)
            if (context is Activity) {
                context.startActivityForResult(intent, requestCode)
                return true
            }
            context.startActivity(intent)
            return true
        }

        if (path.startsWith(NATIVE_PAGE_SUFFIX)) {
            ARouter.getInstance().build(path).withMap(params).navigation()
            return true
        }

        return false
    }

    private fun <K, V> Map<K, V>?.safe(): Map<K, V> {
        return this ?: mapOf()
    }


    private fun Postcard.withMap(map: Map<String, Any?>?): Postcard {
        map?.forEach { entry ->
            when (val value: Any? = entry.value) {
                is Int -> this.withInt(entry.key, value)
                is Double -> this.withDouble(entry.key, value)
                is Float -> this.withFloat(entry.key, value)
                is String -> this.withString(entry.key, value)
                is Boolean -> this.withBoolean(entry.key, value)
                is Serializable -> this.withSerializable(entry.key, value)
                is Parcelable -> this.withParcelable(entry.key, value)
                else -> {

                }
            }
        }
        return this
    }
}

