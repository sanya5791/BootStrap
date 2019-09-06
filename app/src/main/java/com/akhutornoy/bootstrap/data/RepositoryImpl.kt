package com.akhutornoy.bootstrap.data

import androidx.lifecycle.LiveData
import com.akhutornoy.bootstrap.data.db.PetsDao
import com.akhutornoy.bootstrap.data.db.entity.PetEntity
import com.akhutornoy.bootstrap.data.mock.MockDataProvider
import com.akhutornoy.bootstrap.data.rest.RemoteApi

class RepositoryImpl(
    private val remoteApi: RemoteApi,
    private val petsDao: PetsDao,
    private val mockDataProvider: MockDataProvider
) : Repository {

    override suspend fun getAllPets(): List<PetEntity> = petsDao.getAll()

    override suspend fun getAllPetsLiveData(): LiveData<List<PetEntity>>  {
        val trendGifs = remoteApi.getTrendingGifs(0)
        val pets = trendGifs.data
            .map { gif -> gif.title }
            .map { title -> PetEntity(title, "Breed") }

        addPets(pets)

        return petsDao.getAllLiveData()
    }

    override suspend fun addPet(petEntity: PetEntity)  = petsDao.insert(petEntity)

    override suspend fun addPets(pets: List<PetEntity>)  = petsDao.insert(pets)

    override suspend fun deletePet(petEntity: PetEntity)  = petsDao.delete(petEntity)

    override suspend fun getMockPictureResId(): Int = mockDataProvider.getPictureResId()

}
