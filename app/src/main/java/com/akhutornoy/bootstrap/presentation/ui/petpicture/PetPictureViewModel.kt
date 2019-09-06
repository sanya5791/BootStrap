package com.akhutornoy.bootstrap.presentation.ui.petpicture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.akhutornoy.bootstrap.di.presentation.ui.petpicture.model.PetWithPicture
import com.akhutornoy.bootstrap.presentation.ui.base.BaseViewModel

class PetPictureViewModel(
    private val interactor: PetPictureInteractor
) : BaseViewModel() {

    private val _pictureResIdLiveData = MutableLiveData<PetWithPicture>()
    val pictureResIdLiveData: LiveData<PetWithPicture>
        get() = _pictureResIdLiveData

    fun loadPicture(petName: String) {
        launchBackgroundJob(
            { interactor.getMockPicture(petName) },
            { pictureResId -> _pictureResIdLiveData.value = pictureResId}
        )
    }

}