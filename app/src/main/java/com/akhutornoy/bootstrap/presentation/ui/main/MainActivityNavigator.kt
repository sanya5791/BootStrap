package com.akhutornoy.bootstrap.presentation.ui.main

import com.akhutornoy.bootstrap.presentation.ui.main.petlist.PetListFragment

interface MainActivityNavigator : PetListFragment.PetListNavigator {
    fun navigateToPetList()
}