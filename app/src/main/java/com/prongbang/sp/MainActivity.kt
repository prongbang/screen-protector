package com.prongbang.sp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prongbang.screenprotect.AndroidScreenProtector

class MainActivity : AppCompatActivity() {

    private val screenProtector by lazy { AndroidScreenProtector.newInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onPause() {
        super.onPause()
        screenProtector.protect()
    }

    override fun onResume() {
        super.onResume()
        screenProtector.unprotect()
    }

    // For Android 12
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        screenProtector.process(hasFocus.not())
    }
}