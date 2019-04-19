package com.activity.mih916.qiitaproject.service

import com.activity.mih916.qiitaproject.entity.UserEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("users")
    fun items(
            @Query("page") page: Int,
            @Query("par_page") perPage: Int
    ): Call<List<UserEntity>>
}