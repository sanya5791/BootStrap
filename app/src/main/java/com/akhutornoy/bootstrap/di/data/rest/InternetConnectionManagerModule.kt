package com.akhutornoy.bootstrap.di.data.rest

import android.content.Context
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import com.akhutornoy.bootstrap.data.rest.InternetConnectionManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InternetConnectionManagerModule {

    @Provides
    @Singleton
    fun provideInternetConnectionManager(
        context: Context,
        networkRequest: NetworkRequest
    ) = InternetConnectionManager(
        context,
        networkRequest
    )

    @Provides
    @Singleton
    fun providesNetworkRequest(): NetworkRequest =
        NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .build()

}