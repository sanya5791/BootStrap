package com.akhutornoy.bootstrap.di.app

import android.content.Context
import com.akhutornoy.bootstrap.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: App) {

    private val context: Context = app.applicationContext

    @Provides
    fun provideApp() = app

    @Provides
    fun provideContext() = context

}