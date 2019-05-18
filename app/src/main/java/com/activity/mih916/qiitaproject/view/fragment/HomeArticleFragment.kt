package com.activity.mih916.qiitaproject.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.activity.mih916.qiitaproject.databinding.FragmentHomeArticleBinding
import com.activity.mih916.qiitaproject.repository.ItemRepository
import com.activity.mih916.qiitaproject.repository.UserRepository
import com.activity.mih916.qiitaproject.view.adapter.ArticleCardAdapter
import com.activity.mih916.qiitaproject.viewmodel.HomeViewModel

class HomeArticleFragment : Fragment(){

    val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.articleInfoList.observe(this, Observer {
            Log.d("######", "list_update")
            val adapter = ArticleCardAdapter(viewModel.articleInfoList.value ?: listOf())
            recycler.adapter = adapter
            adapter.notifyDataSetChanged()
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentHomeArticleBinding.inflate(inflater, container, false).apply {
            recycler = articleRecycler
            val adapter = ArticleCardAdapter(viewModel.articleInfoList.value ?: listOf())
            articleRecycler.layoutManager = LinearLayoutManager(activity)
            articleRecycler.adapter = adapter
            val itemRepository = ItemRepository()
            val userRepository = UserRepository()

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
        return binding.root
    }
}