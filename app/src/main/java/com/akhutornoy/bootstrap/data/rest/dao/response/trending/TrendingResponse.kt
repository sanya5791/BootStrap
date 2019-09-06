package com.akhutornoy.bootstrap.data.rest.dao.response.trending

data class TrendingResponse(
    val `data`: List<Data>,
    val pagination: Pagination
)