package com.prongbang.screenprotect.screen

import android.view.ViewGroup

interface ScreenViewUtility {
    fun view(): ViewGroup?
    fun visible()
    fun invisible()
}