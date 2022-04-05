package com.prongbang.screenprotect.flag

import android.app.Activity
import android.view.WindowManager

class SecureFlagUtility(
    private var activity: Activity?
) : FlagUtility {

    override fun inject(activity: Activity?) {
        this.activity = activity
    }

    override fun flag() {
        activity?.window?.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
    }

    override fun clear() {
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
    }
}