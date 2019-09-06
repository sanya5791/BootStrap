package com.akhutornoy.bootstrap.data.rest

import android.content.Context
import com.akhutornoy.bootstrap.R
import retrofit2.HttpException

class RestExceptionHandler(
    private val context: Context
) {

    fun handle(error: Throwable): Throwable {
        return when (error) {
            is HttpException -> ExampleBackendException(getBackendErrorMessage(error))
            else -> throw error
        }
    }

    private fun getBackendErrorMessage(error: HttpException): String {
        val code = error.code()
        return when (code) {
            400 -> context.getString(R.string.http_error_400)
            401 -> context.getString(R.string.http_error_401)
            403 -> context.getString(R.string.http_error_403)
            404 -> context.getString(R.string.http_error_404)
            429 -> context.getString(R.string.http_error_429)
            else -> context.getString(R.string.http_error_code, code)
        }
    }

    class ExampleBackendException(message: String) : RuntimeException(message)

}