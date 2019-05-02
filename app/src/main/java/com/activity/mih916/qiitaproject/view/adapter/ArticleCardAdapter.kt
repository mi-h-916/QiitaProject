package com.activity.mih916.qiitaproject.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.activity.mih916.qiitaproject.R
import com.activity.mih916.qiitaproject.databinding.ArticleCardItemBinding
import com.activity.mih916.qiitaproject.entity.ItemEntity

class ArticleCardAdapter(private val articleInfoList: List<ItemEntity>): RecyclerView.Adapter<ArticleCardAdapter.ItemHolder>() {

    override fun getItemCount(): Int {
        return articleInfoList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val tagList = mutableListOf<String>()
        articleInfoList[position].tags.forEach {
            tagList.add(it.name)
        }
        holder.binding.acountName.text = articleInfoList[position].user.id
        holder.binding.articleTitle.text = articleInfoList[position].title
        val tags = tagList.joinToString(",")
        holder.binding.articleTag.text = tags
        holder.binding.articleLikeCount.text = articleInfoList[position].likes_count.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.article_card_item, parent, false)
        return ItemHolder(v)
    }

    class ItemHolder(v: View) : RecyclerView.ViewHolder(v) {
        val binding = DataBindingUtil.bind<ArticleCardItemBinding>(v)!!
    }
}
