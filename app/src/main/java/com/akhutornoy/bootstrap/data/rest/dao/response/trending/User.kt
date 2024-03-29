package com.akhutornoy.bootstrap.data.rest.dao.response.trending

data class User(
    val avatar_url: String,
    val banner_image: String,
    val banner_url: String,
    val display_name: String,
    val is_verified: Boolean,
    val profile_url: String,
    val username: String
)