package com.activity.mih916.qiitaproject.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.activity.mih916.qiitaproject.databinding.FragmentSearchBinding

class SearchFragment :Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentSearchBinding.inflate(inflater, container, false).apply {

        }
        return binding.root
    }
}