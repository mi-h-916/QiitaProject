package com.activity.mih916.qiitaproject.view.activity

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.*
import com.activity.mih916.qiitaproject.R
import com.activity.mih916.qiitaproject.databinding.ActivitySplashBinding


class SplashActivity :AppCompatActivity(){
    val binding :ActivitySplashBinding by lazy {
        DataBindingUtil.setContentView<ActivitySplashBinding>(this, R.layout.activity_splash)
    }

    private val DURATION_TIME = 2000L
    private val REPEAT_COUNT = Animation.ABSOLUTE
    private val REPEAT_MODE = Animation.RESTART

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.titleHead.text = "Q"

        val translateVerticalAnimation = TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, -0.2f,
                Animation.RELATIVE_TO_PARENT, 0.0f
        )

        translateVerticalAnimation.duration = DURATION_TIME
        translateVerticalAnimation.repeatCount = REPEAT_COUNT
        translateVerticalAnimation.repeatMode = REPEAT_MODE
        translateVerticalAnimation.interpolator = BounceInterpolator()
        translateVerticalAnimation.fillAfter = true
        translateVerticalAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationEnd(animation: Animation?) {
                val translateHorizontalAnimation = TranslateAnimation(
                        Animation.RELATIVE_TO_PARENT, 0f,
                        Animation.RELATIVE_TO_PARENT, -0.1f,
                        Animation.RELATIVE_TO_PARENT, 0.0f,
                        Animation.RELATIVE_TO_PARENT, 0.0f
                )

                translateHorizontalAnimation.duration = DURATION_TIME
                translateHorizontalAnimation.fillAfter = true
                binding.titleHead.startAnimation(translateHorizontalAnimation)


                val alphaAnimation = AlphaAnimation(0f, 1.0f)
                alphaAnimation.duration = DURATION_TIME

                val animationSet = AnimationSet(true)
                animationSet.addAnimation(translateHorizontalAnimation)
                animationSet.addAnimation(alphaAnimation)
                animationSet.fillAfter = true
                animationSet.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationEnd(animation: Animation?) {
                        binding.titleContent.visibility = View.GONE
                        navigateToHomeActivity()
                    }
                    override fun onAnimationRepeat(animation: Animation?) { }

                    override fun onAnimationStart(animation: Animation?) {
                        binding.titleContent.visibility = View.VISIBLE
                    }
                })

                binding.titleContent.startAnimation(animationSet)
            }

            override fun onAnimationRepeat(animation: Animation?) { }

            override fun onAnimationStart(animation: Animation?) { }
        })

        binding.titleHead.startAnimation(translateVerticalAnimation)
    }

    private fun navigateToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}