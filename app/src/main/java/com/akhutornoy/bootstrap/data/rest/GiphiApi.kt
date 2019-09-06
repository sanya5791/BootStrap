package com.akhutornoy.bootstrap.data.rest

import com.akhutornoy.bootstrap.data.rest.dao.response.trending.TrendingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphiApi {

    @GET("trending")
    suspend fun getTrendingGifs(@Query("offset") offset: Int): TrendingResponse

}