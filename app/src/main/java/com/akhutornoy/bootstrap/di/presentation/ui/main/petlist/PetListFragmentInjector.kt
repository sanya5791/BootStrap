package com.akhutornoy.bootstrap.di.presentation.ui.main.petlist

import com.akhutornoy.bootstrap.di.scope.FragmentScope
import com.akhutornoy.bootstrap.presentation.ui.main.petlist.PetListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PetListFragmentInjector {

    @ContributesAndroidInjector(
        modules = [
            PetListViewModelModule::class,
            PetListNavigatorModule::class
        ]
    )
    @FragmentScope
    abstract fun provideFoundryFragment(): PetListFragment

}