package com.akhutornoy.bootstrap.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.akhutornoy.bootstrap.data.db.entity.PetEntity

@Database(entities = [
        PetEntity::class
], version = 1, exportSchema = false)
abstract class Db : RoomDatabase() {
    abstract fun petsDao(): PetsDao
}