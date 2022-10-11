package com.prongbang.screenprotect.screen

import android.app.Activity
import android.view.View
import android.view.ViewGroup

class AndroidScreenViewUtility(
    private val activity: Activity?
) : ScreenViewUtility {

    override fun view(): ViewGroup? = activity?.findViewById(android.R.id.content)

    override fun visible() {
        view()?.visibility = View.VISIBLE
    }

    override fun invisible() {
        view()?.visibility = View.INVISIBLE
    }
}