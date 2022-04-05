package com.prongbang.screenprotect

interface ScreenProtector {
    fun process(enabled: Boolean)
    fun protect()
    fun unprotect()
}