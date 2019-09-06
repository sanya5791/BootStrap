package com.akhutornoy.bootstrap.di.presentation.ui.petpicture

import com.akhutornoy.bootstrap.di.scope.ActivityScope
import com.akhutornoy.bootstrap.presentation.ui.petpicture.PetPictureActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PetPictureActivityInjector {

    @ContributesAndroidInjector(
        modules = [
            PetPictureViewModelModule::class
        ]
    )
    @ActivityScope
    abstract fun provide(): PetPictureActivity

}