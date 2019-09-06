package com.akhutornoy.bootstrap.di.presentation.ui.petpicture

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.akhutornoy.bootstrap.di.scope.ActivityScope
import com.akhutornoy.bootstrap.presentation.ui.petpicture.PetPictureActivity
import com.akhutornoy.bootstrap.presentation.ui.petpicture.PetPictureInteractor
import com.akhutornoy.bootstrap.presentation.ui.petpicture.PetPictureViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class PetPictureViewModelModule {

    @Provides
    @ActivityScope
    fun provideListViewModel(
        activity: PetPictureActivity,
        factory: ViewModelFactory): PetPictureViewModel =
        ViewModelProviders.of(activity, factory).get(PetPictureViewModel::class.java)

    class ViewModelFactory @Inject constructor(
        private val interactor: PetPictureInteractor
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        @NonNull
        override fun <T : ViewModel> create(@NonNull modelClass: Class<T>): T {
            return (when (modelClass) {
                PetPictureViewModel::class.java -> PetPictureViewModel(interactor)
                else -> throw IllegalArgumentException("Don't have ViewModel for '$modelClass'")
            }) as T
        }
    }

}