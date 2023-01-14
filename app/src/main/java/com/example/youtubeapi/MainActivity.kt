package com.example.youtubeapi

import android.view.LayoutInflater
import com.example.youtubeapi.base.BaseActivity
import com.example.youtubeapi.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
       return ActivityMainBinding.inflate(inflater)
    }

    override fun initView() {
        super.initView()
    }
}