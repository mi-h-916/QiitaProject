package com.activity.mih916.qiitaproject.entity

import com.squareup.moshi.Json

data class ItemEntity (
        @Json(name = "id")
        val id: String,
        @Json(name = "title")
        val title: String,
        @Json(name = "body")
        val body: String
)