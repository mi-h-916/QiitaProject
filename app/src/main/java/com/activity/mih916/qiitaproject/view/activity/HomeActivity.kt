package com.activity.mih916.qiitaproject.view.activity

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.activity.mih916.qiitaproject.R
import com.activity.mih916.qiitaproject.databinding.ActivityMainBinding
import com.activity.mih916.qiitaproject.repository.ItemRepository
import com.activity.mih916.qiitaproject.repository.UserRepository
import com.activity.mih916.qiitaproject.view.adapter.ArticleCardAdapter

class HomeActivity : AppCompatActivity() {

    val binding:ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = ArticleCardAdapter()
        binding.articleRecycler.layoutManager = LinearLayoutManager(this)
        binding.articleRecycler.adapter = adapter
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
