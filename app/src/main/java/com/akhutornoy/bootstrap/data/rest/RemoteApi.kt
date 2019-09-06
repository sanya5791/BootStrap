package com.akhutornoy.bootstrap.data.rest

import com.akhutornoy.bootstrap.data.rest.dao.response.trending.TrendingResponse


class RemoteApi(
    private val giphiApi: GiphiApi,
    private val restExceptionHandler: RestExceptionHandler
) : GiphiApi {

    override suspend fun getTrendingGifs(offset: Int): TrendingResponse =
        makeQueryOrThrowHandledError { giphiApi.getTrendingGifs(offset) }

    private suspend fun <T> makeQueryOrThrowHandledError(query: suspend () -> T): T {
        return kotlin.runCatching {
            query.invoke()
        }
            .getOrElse { error -> throw restExceptionHandler.handle(error) }
    }

}
