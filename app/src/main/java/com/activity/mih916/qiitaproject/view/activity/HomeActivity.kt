package com.activity.mih916.qiitaproject.view.activity

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.activity.mih916.qiitaproject.R
import com.activity.mih916.qiitaproject.databinding.ActivityMainBinding
import com.activity.mih916.qiitaproject.repository.ItemRepository
import com.activity.mih916.qiitaproject.repository.UserRepository

class HomeActivity : AppCompatActivity() {

    val binding:ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO: Use response data
        val tagList = mutableListOf<String>("kotlin","android","livedata","android開発")
        binding.acountName.text = "@ggk_odiic"
        binding.articleTitle.text = "LiveDataを用いてDataBindingでLayoutを制御してみた結果Activity内の状態がどういい方向に変わっていったか書き記してみる"
        val tags = tagList.joinToString(",")
        binding.articleTag.text = tags
        val itemRepository = ItemRepository()
        val userRepository = UserRepository()

        itemRepository.getItemList { articleList ->
            articleList.forEach { article ->
                Log.d("test_data", "title : ${article.title}")
            }
        }
        userRepository.getUserList { userList ->
            userList.forEach { user ->
               Log.d("user_data", "user : ${user.name}")
            }
        }
    }
}
