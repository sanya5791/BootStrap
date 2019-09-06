package com.akhutornoy.bootstrap.di.data.rest

import com.akhutornoy.bootstrap.data.rest.GiphiApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val END_POINT = "https://api.giphy.com/v1/gifs/"

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideGiphiApi(retrofit: Retrofit): GiphiApi {
        return retrofit.create<GiphiApi>(GiphiApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {

        return Retrofit.Builder()
            .baseUrl(END_POINT)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Reusable
    fun provideGsonConverterFactory(): GsonConverterFactory {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return GsonConverterFactory.create(gson)
    }

}
