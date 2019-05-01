package com.activity.mih916.qiitaproject.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
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
import com.activity.mih916.qiitaproject.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {

    val binding:ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = ArticleCardAdapter(viewModel.articleInfoList.value ?: listOf())
        binding.articleRecycler.layoutManager = LinearLayoutManager(this)
        binding.articleRecycler.adapter = adapter
        val itemRepository = ItemRepository()
        val userRepository = UserRepository()

        viewModel.articleInfoList.observe(this, Observer {
            Log.d("######", "list_update")
            val adapter = ArticleCardAdapter(viewModel.articleInfoList.value ?: listOf())
            binding.articleRecycler.adapter = adapter
            adapter.notifyDataSetChanged()
        })

        itemRepository.getItemList { articleList ->
            articleList.forEach { article ->
                Log.d("test_data", "title : ${article.title}")
            }
            viewModel.articleInfoList.value = articleList
        }
        userRepository.getUserList { userList ->
            userList.forEach { user ->
                Log.d("user_data", "user : ${user.name}")
            }
        }
    }
}
