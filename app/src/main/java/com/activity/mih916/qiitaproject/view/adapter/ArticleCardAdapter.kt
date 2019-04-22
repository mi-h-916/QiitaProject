package com.activity.mih916.qiitaproject.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.activity.mih916.qiitaproject.R
import com.activity.mih916.qiitaproject.databinding.ArticleCardItemBinding

class ArticleCardAdapter(): RecyclerView.Adapter<ArticleCardAdapter.ItemHolder>() {

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        //TODO: Use response data
        val tagList = mutableListOf<String>("kotlin", "android", "livedata", "android開発")
        holder.binding.acountName.text = "@ggk_odiic"
        holder.binding.articleTitle.text = "LiveDataを用いてDataBindingでLayoutを制御してみた結果Activity内の状態がどういい方向に変わっていったか書き記してみる"
        val tags = tagList.joinToString(",")
        holder.binding.articleTag.text = tags
        holder.binding.articleLikeCount.text = "100"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.article_card_item, parent, false)
        return ItemHolder(v)
    }

    class ItemHolder(v: View) : RecyclerView.ViewHolder(v) {
        val binding = DataBindingUtil.bind<ArticleCardItemBinding>(v)!!
    }
}
