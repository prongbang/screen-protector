package com.prongbang.screenprotect

import android.app.Activity
import com.prongbang.screenprotect.flag.FlagUtility
import com.prongbang.screenprotect.flag.SecureFlagUtility
import com.prongbang.screenprotect.screen.AndroidScreenViewUtility
import com.prongbang.screenprotect.screen.ScreenViewUtility
import com.prongbang.screenprotect.sdk.AndroidSdkVersionUtility
import com.prongbang.screenprotect.version.DefaultIsMoreThanEqualsAndroid12UseCase
import com.prongbang.screenprotect.version.IsMoreThanEqualsAndroid12UseCase

/**
 * How to use:
 * class MainActivity : AppCompatActivity() {
 *
 *     private val screenProtector by lazy { AndroidScreenProtector.newInstance(this) }
 *
 *      override fun onPause() {
 *          super.onPause()
 *          screenProtector.protect()
 *      }
 *
 *      override fun onResume() {
 *          super.onResume()
 *          screenProtector.unprotect()
 *      }
 *
 *      // For Android 12
 *      override fun onWindowFocusChanged(hasFocus: Boolean) {
 *          super.onWindowFocusChanged(hasFocus)
 *          screenProtector.process(hasFocus.not())
 *      }
 * }
 */
class AndroidScreenProtector(
    private val flagUtility: FlagUtility,
    private val screenViewUtility: ScreenViewUtility,
    private val isMoreThanEqualsAndroid12UseCase: IsMoreThanEqualsAndroid12UseCase
) : ScreenProtector {

    override fun process(enabled: Boolean) {
        try {
            if (enabled) {
                if (isMoreThanEqualsAndroid12UseCase.execute()) {
                    screenViewUtility.invisible()
                }
                protect()
            } else {
                if (isMoreThanEqualsAndroid12UseCase.execute()) {
                    screenViewUtility.visible()
                }
                unprotect()
            }
        } catch (_: Exception) { }
    }

    override fun protect() {
        flagUtility.flag()
    }

    override fun unprotect() {
        flagUtility.clear()
    }

    companion object {
        fun newInstance(activity: Activity?): ScreenProtector = AndroidScreenProtector(
            SecureFlagUtility(activity),
            AndroidScreenViewUtility(activity),
            DefaultIsMoreThanEqualsAndroid12UseCase(
                AndroidSdkVersionUtility()
            ),
        )
    }
}