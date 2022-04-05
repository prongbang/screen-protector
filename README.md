# screen-protector

[![](https://jitpack.io/v/prongbang/screen-protector.svg)](https://jitpack.io/#prongbang/screen-protector)

Safe Data Leakage via Application Background Screenshot and Prevent Screenshot for Android

![screen-protector.gif](screen-protector.gif){width=50%}

## Setup

- `build.gradle`

```groovy
buildscript {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

- `settings.gradle`

```groovy
dependencyResolutionManagement {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

- `app/build.gradle`

```groovy
implementation 'com.github.prongbang:screen-protector:1.0.0'
```

## How to use

You can use 2 options.

### 1. Use in Activity

```kotlin
import com.prongbang.screenprotect.AndroidScreenProtector

class MainActivity : AppCompatActivity() {

    private val screenProtector by lazy { AndroidScreenProtector.newInstance(this) }

    override fun onPause() {
        super.onPause()
        screenProtector.protect()
    }

    override fun onResume() {
        super.onResume()
        screenProtector.unprotect()
    }

    // For Android 12+
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        screenProtector.process(hasFocus.not())
    }
}
```

### 2. Use in Application

```kotlin
import com.prongbang.screenprotect.ScreenProtectorByActivityLifecycle

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(ScreenProtectorByActivityLifecycle())
    }
}
```