package com.akhutornoy.bootstrap.data.rest.okhttpinterceptor

import okhttp3.Interceptor
import okhttp3.Response

private const val HEADER_API_KEY = "api_key"
private const val HEADER_API_KEY_VALUE = "0PbLW7uSqobZh8Hf2cBXjfrMb8p2ow7K"

class AuthHeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader(
                HEADER_API_KEY,
                HEADER_API_KEY_VALUE
            )
            .build()
        return chain.proceed(request)
    }

}