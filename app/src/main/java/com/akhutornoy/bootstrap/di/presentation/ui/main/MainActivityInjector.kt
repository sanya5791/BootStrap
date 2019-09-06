package com.akhutornoy.bootstrap.di.presentation.ui.main

import com.akhutornoy.bootstrap.di.presentation.ui.main.petlist.PetListFragmentInjector
import com.akhutornoy.bootstrap.di.scope.ActivityScope
import com.akhutornoy.bootstrap.presentation.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityInjector {

    @ContributesAndroidInjector(
        modules = [
            MainActivityNavigatorModule::class,
            PetListFragmentInjector::class
        ]
    )
    @ActivityScope
    abstract fun provideMainActivity(): MainActivity

}