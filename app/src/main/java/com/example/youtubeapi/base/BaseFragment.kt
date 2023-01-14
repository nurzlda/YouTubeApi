package com.example.youtubeapi.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment() {

    protected lateinit var binding: VB
    protected abstract val viewModel : VM

    abstract fun inflateViewBinding(inflater: LayoutInflater, container: ViewGroup?) : VB
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = inflateViewBinding(inflater, container)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initView()
        initListener()
        checkInternet()
    }

    abstract fun initView()
    open fun initListener(){}
    open fun initViewModel(){}
    open fun checkInternet(){}
}