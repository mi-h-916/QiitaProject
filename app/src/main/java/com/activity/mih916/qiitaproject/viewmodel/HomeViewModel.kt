package com.activity.mih916.qiitaproject.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.activity.mih916.qiitaproject.entity.ItemEntity

class HomeViewModel :ViewModel() {

    val articleInfoList = MutableLiveData<List<ItemEntity>>()

}