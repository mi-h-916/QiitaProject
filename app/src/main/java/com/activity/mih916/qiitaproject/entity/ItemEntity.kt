package com.activity.mih916.qiitaproject.entity

import com.squareup.moshi.Json

data class ItemEntity (
        @Json(name = "id")
        val id: String,
        @Json(name = "title")
        val title: String,
        @Json(name = "body")
        val body: String,
        @Json(name = "comments_count")
        val comments_count: Int,
        @Json(name = "likes_count")
        val likes_count: Int,
        @Json(name = "updated_at")
        val update_time: String,
        @Json(name = "user")
        val user: UserEntity
)