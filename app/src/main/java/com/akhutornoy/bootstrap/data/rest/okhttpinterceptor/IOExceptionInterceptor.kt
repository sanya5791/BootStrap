package com.akhutornoy.bootstrap.data.rest.okhttpinterceptor

import com.akhutornoy.bootstrap.data.rest.InternetConnectionManager
import com.akhutornoy.bootstrap.data.rest.exception.NoInternetConnectionException
import com.akhutornoy.bootstrap.data.rest.exception.OkHttpException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class IOExceptionInterceptor(
    private val internetConnectionManager: InternetConnectionManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!internetConnectionManager.isConnected()) {
            throw NoInternetConnectionException()
        }

        return Result.runCatching { chain.proceed(chain.request()) }
            .recoverCatching { error -> throw getHandledIoException(error) }
            .getOrThrow()
    }

    /**
     * OkHttp errors are only IOException and should be handled here
     * @return custom exception; must be a type of IOException
     */
    private fun getHandledIoException(error: Throwable): IOException {
        if (error is IOException) {
            return when(error) {
                /* add here own error handling */
                else -> OkHttpException(error)
            }
        } else {
            throw IllegalArgumentException("Not a case")
        }
    }

}