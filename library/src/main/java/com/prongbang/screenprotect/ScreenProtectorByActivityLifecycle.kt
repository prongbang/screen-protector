package com.prongbang.screenprotect

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.prongbang.screenprotect.flag.SecureFlagUtility

/**
 * How to use:
 * class MainApplication: Application() {
 *     override fun onCreate() {
 *         super.onCreate()
 *         registerActivityLifecycleCallbacks(ScreenProtectorByActivityLifecycle())
 *     }
 * }
 */
class ScreenProtectorByActivityLifecycle : Application.ActivityLifecycleCallbacks {

    private val flagUtility by lazy { SecureFlagUtility(null) }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
    }

    override fun onActivityStarted(activity: Activity) {
        flagUtility.apply {
            inject(activity)
            clear()
        }
    }

    override fun onActivityResumed(activity: Activity) {
        flagUtility.apply {
            inject(activity)
            clear()
        }
    }

    override fun onActivityPaused(activity: Activity) {
        flagUtility.apply {
            inject(activity)
            flag()
        }
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
    }

}