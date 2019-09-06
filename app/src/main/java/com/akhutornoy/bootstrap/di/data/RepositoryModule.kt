package com.akhutornoy.bootstrap.di.data

import com.akhutornoy.bootstrap.data.Repository
import com.akhutornoy.bootstrap.data.RepositoryImpl
import com.akhutornoy.bootstrap.data.db.PetsDao
import com.akhutornoy.bootstrap.data.mock.MockDataProvider
import com.akhutornoy.bootstrap.data.rest.RemoteApi
import com.akhutornoy.bootstrap.di.data.db.RoomModule
import com.akhutornoy.bootstrap.di.data.rest.RemoteApiModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        RoomModule::class,
        RemoteApiModule::class
    ]
)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesRepository(remoteApi: RemoteApi,
                           petsDao: PetsDao
    ): Repository =
        RepositoryImpl(remoteApi, petsDao, MockDataProvider())

}