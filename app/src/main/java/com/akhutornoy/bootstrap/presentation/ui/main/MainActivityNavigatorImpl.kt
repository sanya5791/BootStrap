package com.akhutornoy.bootstrap.presentation.ui.main

import androidx.annotation.IdRes
import androidx.fragment.app.commit
import com.akhutornoy.bootstrap.R
import com.akhutornoy.bootstrap.presentation.ui.base.BaseFragment
import com.akhutornoy.bootstrap.presentation.ui.main.model.PetModel
import com.akhutornoy.bootstrap.presentation.ui.main.petlist.PetListFragment
import com.akhutornoy.bootstrap.presentation.ui.petpicture.PetPictureActivity

class MainActivityNavigatorImpl(
    private val activity: MainActivity
) : MainActivityNavigator {
    override fun navigateToPetList() {
        navigateToFragment(PetListFragment.newInstance())
    }

    private fun navigateToFragment(fragment: BaseFragment) {
        activity.supportFragmentManager.commit {
            replace(getFragmentContainerId(), fragment) }
    }

    override fun navigateToPetPicture(pet: PetModel) {
        activity.startActivity(PetPictureActivity.newIntent(activity, pet.name))
    }

    @IdRes
    private fun getFragmentContainerId() = R.id.fragment_container

}