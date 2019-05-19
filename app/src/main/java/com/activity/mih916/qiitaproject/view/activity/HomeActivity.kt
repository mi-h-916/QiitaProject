package com.activity.mih916.qiitaproject.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.internal.BottomNavigationMenu
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import com.activity.mih916.qiitaproject.R
import com.activity.mih916.qiitaproject.databinding.ActivityMainBinding
import com.activity.mih916.qiitaproject.view.fragment.HomeArticleFragment
import com.activity.mih916.qiitaproject.view.fragment.SearchFragment
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
        binding.bottomNavigationBar.setOnNavigationItemSelectedListener( object: BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(p0: MenuItem): Boolean {
                    when(p0.itemId) {
                        R.id.item1 -> {
                            val fragment = HomeArticleFragment()
                            val transaction = supportFragmentManager.beginTransaction()
                            transaction.replace(binding.container.id, fragment).commit()
                            return true
                        }
                        R.id.item2 -> {
                            val fragment = SearchFragment()
                            val transaction = supportFragmentManager.beginTransaction()
                            transaction.replace(binding.container.id, fragment).commit()
                            return true
                        }
                        R.id.item3 -> {
                            return true
                        }
                    }
                    return false
                }
            }
        )
        val fragment = HomeArticleFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(binding.container.id, fragment).commit()
    }
}
