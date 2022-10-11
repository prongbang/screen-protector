package com.prongbang.screenprotect.flag

import android.app.Activity

interface FlagUtility {
    fun inject(activity: Activity?)
    fun flag()
    fun clear()
}