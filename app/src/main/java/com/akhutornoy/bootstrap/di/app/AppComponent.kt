package com.akhutornoy.bootstrap.di.app

import com.akhutornoy.bootstrap.App
import com.akhutornoy.bootstrap.di.data.RepositoryModule
import com.akhutornoy.bootstrap.di.presentation.ui.UiModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        RepositoryModule::class,
        UiModule::class
    ]
)
interface AppComponent : AndroidInjector<App>