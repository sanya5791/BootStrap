package com.akhutornoy.bootstrap.usecase

import androidx.lifecycle.LiveData
import com.akhutornoy.bootstrap.data.Repository
import com.akhutornoy.bootstrap.data.db.entity.PetEntity
import javax.inject.Inject

class GetListUseCase @Inject constructor(
    private val repository: Repository
) : BaseUseCase<LiveData<List<PetEntity>>, Unit>() {

    override suspend fun getResult(params: Unit): LiveData<List<PetEntity>> {
        return repository.getAllPetsLiveData()
    }

}