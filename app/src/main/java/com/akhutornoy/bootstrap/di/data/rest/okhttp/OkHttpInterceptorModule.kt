package com.akhutornoy.bootstrap.di.data.rest.okhttp

import com.akhutornoy.bootstrap.data.rest.InternetConnectionManager
import com.akhutornoy.bootstrap.data.rest.okhttpinterceptor.AuthHeaderInterceptor
import com.akhutornoy.bootstrap.data.rest.okhttpinterceptor.IOExceptionInterceptor
import com.akhutornoy.bootstrap.di.data.rest.InternetConnectionManagerModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        InternetConnectionManagerModule::class
    ]
)
class OkHttpInterceptorModule {

    @Provides
    @Singleton
    fun provideIOExceptionInterceptor(internetConnectionManager: InternetConnectionManager) =
        IOExceptionInterceptor(internetConnectionManager)

    @Provides
    @Singleton
    fun provideAuthHeaderInterceptor() =
        AuthHeaderInterceptor()

}