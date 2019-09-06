package com.akhutornoy.bootstrap.di.presentation.ui.petpicture.model

import androidx.annotation.DrawableRes

data class PetWithPicture(
    val name: String,
    @DrawableRes
    val pictureResId: Int
)