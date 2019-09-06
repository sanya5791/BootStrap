package com.akhutornoy.bootstrap.di.data.rest

import android.content.Context
import com.akhutornoy.bootstrap.data.rest.GiphiApi
import com.akhutornoy.bootstrap.data.rest.RemoteApi
import com.akhutornoy.bootstrap.data.rest.RestExceptionHandler
import com.akhutornoy.bootstrap.di.data.rest.okhttp.OkHttpClientModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        RetrofitModule::class,
        OkHttpClientModule::class
    ]
)
class RemoteApiModule {

    @Provides
    @Singleton
    fun providesRemoteApi(
        giphiApi: GiphiApi,
        restExceptionHandler: RestExceptionHandler
    ) = RemoteApi(
        giphiApi,
        restExceptionHandler
    )

    @Provides
    @Singleton
    fun provideRestExceptionHandler(context: Context) = RestExceptionHandler(context)

}