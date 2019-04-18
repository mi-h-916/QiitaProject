package com.activity.mih916.qiitaproject.repository

import com.activity.mih916.qiitaproject.entity.ItemEntity
import com.activity.mih916.qiitaproject.service.ItemService
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ItemRepository {

    private var itemService: ItemService

    init {
        val okHttpClient= OkHttpClient.Builder().build()
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://qiita.com/api/v2/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(okHttpClient)
                .build()
        itemService = retrofit.create(ItemService::class.java)
    }

    fun getItemList(callback: (List<ItemEntity>) -> Unit) {
        itemService.items(page = 3, perPage = 60).enqueue( object: Callback<List<ItemEntity>> {
            override fun onResponse(call: Call<List<ItemEntity>>?, response: Response<List<ItemEntity>>?) {
                response?.let {
                    if(it.isSuccessful) it.body()?.let {
                        callback(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<ItemEntity>>?, t: Throwable?) {

            }
        }
        )
    }
}