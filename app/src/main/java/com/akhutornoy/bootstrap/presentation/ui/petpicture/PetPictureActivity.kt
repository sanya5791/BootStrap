package com.akhutornoy.bootstrap.presentation.ui.petpicture

import android.content.Context
import android.content.Intent
import androidx.lifecycle.Observer
import com.akhutornoy.bootstrap.R
import com.akhutornoy.bootstrap.di.presentation.ui.petpicture.model.PetWithPicture
import com.akhutornoy.bootstrap.presentation.ui.base.BaseViewModel
import com.akhutornoy.bootstrap.presentation.ui.base.BaseViewModelActivity
import kotlinx.android.synthetic.main.activity_pet_picture.*
import javax.inject.Inject

class PetPictureActivity : BaseViewModelActivity() {

    @Inject
    lateinit var viewModel: PetPictureViewModel

    override fun getActivityLayout(): Int = R.layout.activity_pet_picture

    override fun initViews() {
        val petName = intent.getStringExtra(ARG_PET_NAME)
        viewModel.loadPicture(petName!!)
    }

    override fun initViewModelObservers() {
        viewModel.pictureResIdLiveData.observe(this, Observer { showPicture(it) })
    }

    private fun showPicture(pet: PetWithPicture) {
        tv_name.text = pet.name
        iv_pet.setImageResource(pet.pictureResId)
    }

    override fun getBaseViewModel(): BaseViewModel = viewModel

    companion object {

        const val ARG_PET_NAME = "ARG_PET_NAME"

        fun newIntent(context: Context, petName: String): Intent {
            return Intent(context, PetPictureActivity::class.java).apply {
                putExtra(ARG_PET_NAME, petName)
            }
        }

    }

}