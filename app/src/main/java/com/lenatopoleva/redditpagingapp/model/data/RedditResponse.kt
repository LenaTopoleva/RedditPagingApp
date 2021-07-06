package com.lenatopoleva.redditpagingapp.model.data

import com.google.gson.annotations.SerializedName
import com.lenatopoleva.redditpagingapp.model.db.entity.RedditPost


data class RedditResponse (
    val kind: String,
    val data: Data
)

data class Data (
    val after: String?,
    val dist: Long,
    val modhash: String,

    @field:SerializedName("geo_filter")
    val geoFilter: Any? = null,

    val children: List<Child>,
    val before: String? = null
)

data class Child (
    val data: RedditPost
)

