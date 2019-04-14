package com.activity.mih916.qiitaproject

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.activity.mih916.qiitaproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding:ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.text.text = "text_change"
    }
}
