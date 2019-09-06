package com.akhutornoy.bootstrap.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseUseCase<out ResultType, in Params> where ResultType : Any {

    protected abstract suspend fun getResult(params: Params): ResultType

    suspend fun execute(
        params: Params
    ): ResultType {
        return withContext(getBackgroundDispatcher()) { getResult(params) }
    }

    protected fun getBackgroundDispatcher() = DEFAULT_BACKGROUND_DISPATCHER

    companion object {
        @JvmStatic
        private val DEFAULT_BACKGROUND_DISPATCHER = Dispatchers.IO
    }

}