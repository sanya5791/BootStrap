package com.akhutornoy.bootstrap.di.presentation.ui

import com.akhutornoy.bootstrap.di.presentation.ui.main.MainActivityInjector
import com.akhutornoy.bootstrap.di.presentation.ui.petpicture.PetPictureActivityInjector
import dagger.Module

@Module(
    includes = [
        MainActivityInjector::class,
        PetPictureActivityInjector::class
    ]
)
class UiModule