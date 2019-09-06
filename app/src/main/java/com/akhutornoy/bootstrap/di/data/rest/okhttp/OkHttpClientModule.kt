package com.akhutornoy.bootstrap.di.data.rest.okhttp

import com.akhutornoy.bootstrap.App
import com.akhutornoy.bootstrap.BuildConfig
import com.akhutornoy.bootstrap.data.rest.okhttpinterceptor.AuthHeaderInterceptor
import com.akhutornoy.bootstrap.data.rest.okhttpinterceptor.IOExceptionInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import javax.inject.Singleton

private const val REST_CACHE = "REST_CACHE"
private const val CACHE_SIZE = (50 * 1024 * 1024).toLong()

@Module(
    includes = [
        OkHttpInterceptorModule::class
    ]
)
class OkHttpClientModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(
        cache: Cache,
        authHeaderInterceptor: AuthHeaderInterceptor,
        iOExceptionInterceptor: IOExceptionInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(authHeaderInterceptor)
            .addInterceptor(iOExceptionInterceptor)
            .cache(cache)
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            builder.addInterceptor(logging)
        }

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideCache(app: App): Cache {
        val file = File(app.cacheDir, REST_CACHE)
        return Cache(file, CACHE_SIZE)
    }

}
