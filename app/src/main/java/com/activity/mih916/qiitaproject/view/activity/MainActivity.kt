package com.activity.mih916.qiitaproject.view.activity

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.activity.mih916.qiitaproject.R
import com.activity.mih916.qiitaproject.databinding.ActivityMainBinding
import com.activity.mih916.qiitaproject.repository.ItemRepository

class MainActivity : AppCompatActivity() {

    val binding:ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.text.text = "file_changed"

        val itemRepository = ItemRepository()

        itemRepository.getItemList { articleList ->
            articleList.forEach { article ->
                Log.d("test_data", "title : ${article.title}")
            }
        }
    }
}
