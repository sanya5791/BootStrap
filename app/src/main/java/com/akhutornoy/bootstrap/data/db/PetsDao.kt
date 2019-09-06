package com.akhutornoy.bootstrap.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.akhutornoy.bootstrap.data.db.entity.PetEntity


@Dao
interface PetsDao {

    @Query("SELECT * FROM Pets")
    fun getAll() : List<PetEntity>

    @Query("SELECT * FROM Pets")
    fun getAllLiveData() : LiveData<List<PetEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(petEntity: PetEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(petEntities: List<PetEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(favoriteEntities: List<PetEntity>)

    @Delete
    fun delete(favoriteEntity: PetEntity)

}