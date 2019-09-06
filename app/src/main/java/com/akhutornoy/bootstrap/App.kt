package com.akhutornoy.bootstrap

import com.akhutornoy.bootstrap.di.app.AppModule
import com.akhutornoy.bootstrap.di.app.DaggerAppComponent
import com.github.ajalt.timberkt.Timber
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        initLogger()
    }

    private fun initLogger() {
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

}