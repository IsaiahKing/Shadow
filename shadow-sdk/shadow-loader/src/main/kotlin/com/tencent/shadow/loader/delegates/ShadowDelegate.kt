package com.tencent.shadow.loader.delegates

import android.content.res.Resources
import com.tencent.shadow.loader.Reporter
import com.tencent.shadow.loader.classloaders.PluginClassLoader
import com.tencent.shadow.loader.managers.PendingIntentManager
import com.tencent.shadow.loader.managers.PluginActivitiesManager
import com.tencent.shadow.loader.managers.PluginPackageManager
import com.tencent.shadow.loader.managers.PluginServicesManager
import com.tencent.shadow.runtime.ShadowApplication

abstract class ShadowDelegate() {
    fun inject(pluginPackageManager: PluginPackageManager) {
        _pluginPackageManager = pluginPackageManager
    }

    fun inject(shadowApplication: ShadowApplication) {
        _pluginApplication = shadowApplication
    }

    fun inject(pluginClassLoader: PluginClassLoader) {
        _pluginClassLoader = pluginClassLoader
    }

    fun inject(resources: Resources) {
        _pluginResources = resources
    }

    fun inject(pluginActivitiesManager: PluginActivitiesManager) {
        _pluginActivitiesManager = pluginActivitiesManager
    }

    fun inject(pluginServicesManager: PluginServicesManager) {
        _pluginServicesManager = pluginServicesManager
    }

    fun inject(pendingIntentManager: PendingIntentManager) {
        _pendingIntentManager = pendingIntentManager
    }

    fun inject(reporter: Reporter) {
        _exceptionReporter = reporter
    }

    private lateinit var _pluginPackageManager: PluginPackageManager
    private lateinit var _pluginApplication: ShadowApplication
    private lateinit var _pluginClassLoader: PluginClassLoader
    private lateinit var _pluginResources: Resources
    private lateinit var _pluginActivitiesManager: PluginActivitiesManager
    private lateinit var _pluginServicesManager: PluginServicesManager
    private lateinit var _pendingIntentManager: PendingIntentManager
    private lateinit var _exceptionReporter: Reporter

    protected val mPluginPackageManager: PluginPackageManager
        get() = _pluginPackageManager
    protected val mPluginApplication: ShadowApplication
        get() = _pluginApplication
    protected val mPluginClassLoader: PluginClassLoader
        get() = _pluginClassLoader
    protected val mPluginResources: Resources
        get() = _pluginResources
    protected val mPluginActivitiesManager: PluginActivitiesManager
        get() = _pluginActivitiesManager
    protected val mPluginServicesManager: PluginServicesManager
        get() = _pluginServicesManager
    protected val mPendingIntentManager: PendingIntentManager
        get() = _pendingIntentManager
    protected val mExceptionReporter: Reporter
        get() = _exceptionReporter

}