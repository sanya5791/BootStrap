package com.akhutornoy.bootstrap.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Pets")
data class PetEntity(
    @PrimaryKey
    val name: String,
    val breed: String
)