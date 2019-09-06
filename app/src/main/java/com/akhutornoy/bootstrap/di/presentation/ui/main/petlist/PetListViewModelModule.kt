package com.akhutornoy.bootstrap.di.presentation.ui.main.petlist

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.akhutornoy.bootstrap.di.scope.ActivityScope
import com.akhutornoy.bootstrap.di.scope.FragmentScope
import com.akhutornoy.bootstrap.presentation.ui.main.MainActivity
import com.akhutornoy.bootstrap.presentation.ui.main.petlist.PetListInteractor
import com.akhutornoy.bootstrap.presentation.ui.main.petlist.PetListViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class PetListViewModelModule {

    @Provides
    @FragmentScope
    fun provideListViewModel(
        activity: MainActivity,
        @Named("PetListViewModelFactory") factory: ViewModelProvider.Factory): PetListViewModel =
        ViewModelProviders.of(activity, factory).get(PetListViewModel::class.java)

    @Provides
    @FragmentScope
    @Named("PetListViewModelFactory")
    fun providesViewModelFactory(interactor: PetListInteractor): ViewModelProvider.Factory =
        ViewModelFactory(
            interactor
        )

    class ViewModelFactory(
        private val interactor: PetListInteractor
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        @NonNull
        override fun <T : ViewModel> create(@NonNull modelClass: Class<T>): T {
            return (when (modelClass) {
                PetListViewModel::class.java -> PetListViewModel(interactor)
                else -> throw IllegalArgumentException("Don't have ViewModel for '$modelClass'")
            }) as T
        }
    }

}