package com.prongbang.screenprotect.version

import android.os.Build
import com.prongbang.screenprotect.sdk.SdkVersionUtility

interface IsMoreThanEqualsAndroid12UseCase {
    fun execute(): Boolean
}

class DefaultIsMoreThanEqualsAndroid12UseCase(
    private val sdkVersionUtility: SdkVersionUtility
) : IsMoreThanEqualsAndroid12UseCase {

    override fun execute(): Boolean {
        return sdkVersionUtility.version() >= Build.VERSION_CODES.R
    }
}