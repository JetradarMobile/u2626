package ru.aviasales.u2626

import android.util.Log
import com.crashlytics.android.Crashlytics
import timber.log.Timber

/**
 * A logging implementation which reports 'info', 'warning', and 'error' logs to Crashlytics.
 */
class CrashlyticsTree : Timber.DebugTree() {

    override fun isLoggable(tag: String?, priority: Int): Boolean = priority >= Log.INFO

    override fun log(priority: Int, tag: String?, message: String, exception: Throwable?) {
        Crashlytics.log(message)
        exception?.takeIf { priority == Log.ERROR }?.let { Crashlytics.logException(it) }
    }
}
