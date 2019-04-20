package com.activity.mih916.qiitaproject.entity

import com.squareup.moshi.Json

data class UserEntity (
        @Json(name = "description")
        val description: String? = null,
        @Json(name = "facebook_id")
        val facebookId: String? = null,
        @Json(name = "followees_count")
        val followeesCount: Int,
        @Json(name = "followers_count")
        val followersCount: Int,
        @Json(name = "github_login_name")
        val githubLoginName: String? = null,
        @Json(name = "id")
        val id: String,
        @Json(name = "items_count")
        val itemsCount: Int,
        @Json(name = "linkedin_id")
        val linkedinId: String? = null,
        @Json(name = "location")
        val location: String? = null,
        @Json(name = "name")
        val name: String? = null,
        @Json(name = "organization")
        val organization: String? = null,
        @Json(name = "permanent_id")
        val permanentId: Int,
        @Json(name = "profile_image_url")
        val profileImageUrl: String,
        @Json(name = "team_only")
        val teamOnly: Boolean,
        @Json(name = "twitter_screen_name")
        val twitterScreenName: String? = null,
        @Json(name = "website_url")
        val websiteUrl: String? = null
)