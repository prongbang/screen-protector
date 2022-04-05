package com.prongbang.screenprotect.sdk

import android.os.Build

class AndroidSdkVersionUtility : SdkVersionUtility {

    override fun version(): Int = Build.VERSION.SDK_INT
}