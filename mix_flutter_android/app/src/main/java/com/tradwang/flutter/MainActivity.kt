package com.tradwang.flutter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.tradwang.basemodule.constants.FlutterRoutesName
import com.tradwang.basemodule.constants.NativeRoutesName

import com.tradwang.fluttermodule.PageRouter
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = NativeRoutesName.MAIN_PAGE)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            PageRouter.openPageByUrl(this, FlutterRoutesName.TEST_PAGE)
        }
    }
}
