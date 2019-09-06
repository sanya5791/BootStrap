package com.akhutornoy.bootstrap.data

import androidx.annotation.DrawableRes
import androidx.lifecycle.LiveData
import com.akhutornoy.bootstrap.data.db.entity.PetEntity

interface Repository {

    suspend fun getAllPets(): List<PetEntity>
    suspend fun getAllPetsLiveData(): LiveData<List<PetEntity>>
    suspend fun addPet(petEntity: PetEntity)
    suspend fun addPets(pets: List<PetEntity>)
    suspend fun deletePet(petEntity: PetEntity)

    suspend fun getMockPictureResId(): Int
}