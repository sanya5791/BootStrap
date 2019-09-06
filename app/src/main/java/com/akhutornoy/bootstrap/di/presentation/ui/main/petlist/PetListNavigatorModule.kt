package com.akhutornoy.bootstrap.di.presentation.ui.main.petlist

import com.akhutornoy.bootstrap.di.scope.FragmentScope
import com.akhutornoy.bootstrap.presentation.ui.main.MainActivity
import com.akhutornoy.bootstrap.presentation.ui.main.MainActivityNavigator
import com.akhutornoy.bootstrap.presentation.ui.main.petlist.PetListFragment
import dagger.Module
import dagger.Provides

@Module
class PetListNavigatorModule {

    @Provides
    @FragmentScope
    fun providePetListNavigator(navigator: MainActivityNavigator): PetListFragment.PetListNavigator =
        navigator
}