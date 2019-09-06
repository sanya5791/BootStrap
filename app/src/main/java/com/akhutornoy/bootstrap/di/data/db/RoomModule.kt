package com.akhutornoy.bootstrap.di.data.db

import android.content.Context
import androidx.room.Room
import com.akhutornoy.bootstrap.data.db.Db
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

private const val DB_NAME = "foundry.db"

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideDb(context: Context): Db =
        Room.databaseBuilder(
            context,
            Db::class.java,
            DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providePetsDao(db: Db) = db.petsDao()

}