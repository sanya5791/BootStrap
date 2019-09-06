package com.akhutornoy.bootstrap.presentation.ui.main.petlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.akhutornoy.bootstrap.data.db.entity.PetEntity
import com.akhutornoy.bootstrap.presentation.ui.main.model.PetModel
import com.akhutornoy.bootstrap.usecase.GetListUseCase
import javax.inject.Inject

class PetListInteractor @Inject constructor(
    private val getListUseCase: GetListUseCase
) {

    suspend fun getPetsLiveData(): LiveData<List<PetModel>> =
        Transformations.map(getListUseCase.execute(Unit), ::mapToModel)

    private fun mapToModel(petsEntity: List<PetEntity>): List<PetModel> =
        petsEntity.map { entity -> PetModel(entity.name, entity.breed) }

}