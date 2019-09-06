package com.akhutornoy.bootstrap.presentation.ui.petpicture

import com.akhutornoy.bootstrap.di.presentation.ui.petpicture.model.PetWithPicture
import com.akhutornoy.bootstrap.usecase.GetMockPictureUseCase
import javax.inject.Inject

class PetPictureInteractor @Inject constructor(
    val getMockPictureUseCase: GetMockPictureUseCase
) {

    suspend fun getMockPicture(petName: String): PetWithPicture {
        val pictureResId = getMockPictureUseCase.execute(Unit)
        return PetWithPicture(petName, pictureResId)
    }

}