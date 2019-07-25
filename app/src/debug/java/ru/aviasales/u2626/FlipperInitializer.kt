package ru.aviasales.u2626

import android.content.Context
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.plugins.crashreporter.CrashReporterPlugin
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.leakcanary.LeakCanaryFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader

object FlipperInitializer {

    fun init(context: Context) {
        SoLoader.init(context, false) // for loading the C++ part of Flipper
        val client = AndroidFlipperClient.getInstance(context)
        client.addPlugin(InspectorFlipperPlugin(context, DescriptorMapping.withDefaults()))
        client.addPlugin(NetworkFlipperPlugin())
        client.addPlugin(LeakCanaryFlipperPlugin())
        client.addPlugin(CrashReporterPlugin.getInstance())
        client.start()
    }
}
