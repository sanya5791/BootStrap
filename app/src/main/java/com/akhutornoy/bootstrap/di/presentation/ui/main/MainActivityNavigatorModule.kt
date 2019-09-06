package com.akhutornoy.bootstrap.di.presentation.ui.main

import com.akhutornoy.bootstrap.di.scope.ActivityScope
import com.akhutornoy.bootstrap.presentation.ui.main.MainActivity
import com.akhutornoy.bootstrap.presentation.ui.main.MainActivityNavigator
import com.akhutornoy.bootstrap.presentation.ui.main.MainActivityNavigatorImpl
import dagger.Module
import dagger.Provides

@Module
class MainActivityNavigatorModule {

    @Provides
    @ActivityScope
    fun provide(mainActivity: MainActivity): MainActivityNavigator =
        MainActivityNavigatorImpl(mainActivity)

}