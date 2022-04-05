package com.prongbang.sp

import android.app.Application
import com.prongbang.screenprotect.ScreenProtectorByActivityLifecycle

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(ScreenProtectorByActivityLifecycle())
    }
}