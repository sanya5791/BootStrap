package com.akhutornoy.bootstrap.presentation.ui.main.petlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.akhutornoy.bootstrap.presentation.ui.base.BaseViewModel
import com.akhutornoy.bootstrap.presentation.ui.main.model.PetModel

class PetListViewModel(
    private val interactor: PetListInteractor
) : BaseViewModel() {

    private val _petsLiveData = MediatorLiveData<List<PetModel>>()
    val petsLiveData: LiveData<List<PetModel>>
        get() = _petsLiveData

    init {
        loadPets()
    }

    fun loadPets() {
        launchBackgroundJob(
            backgroundJob = { interactor.getPetsLiveData() },
            onSuccess = ::addPetsLiveDataSource
        )
    }

    private fun addPetsLiveDataSource(petsLiveData: LiveData<List<PetModel>>) {
        _petsLiveData.addSource(petsLiveData) { pets -> _petsLiveData.value = pets }
    }

}