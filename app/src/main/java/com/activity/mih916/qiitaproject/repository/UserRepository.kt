package com.activity.mih916.qiitaproject.repository

import android.util.Log
import com.activity.mih916.qiitaproject.entity.ItemEntity
import com.activity.mih916.qiitaproject.entity.UserEntity
import com.activity.mih916.qiitaproject.service.UserService
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class UserRepository {

    private var userService: UserService

    init {
        val okHttpClient= OkHttpClient.Builder().build()
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://qiita.com/api/v2/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(okHttpClient)
                .build()
        userService = retrofit.create(UserService::class.java)
    }

    fun getUserList(callback: (List<UserEntity>) -> Unit) {
        userService.items(page = 3, perPage = 60).enqueue( object: Callback<List<UserEntity>> {
            override fun onResponse(call: Call<List<UserEntity>>?, response: Response<List<UserEntity>>?) {
                response?.let {
                    if(it.isSuccessful) it.body()?.let {
                        callback(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<UserEntity>>?, t: Throwable?) {
                Log.d("########", "error")
            }
        }
        )
    }
}