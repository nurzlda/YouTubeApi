package com.example.youtubeapi.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.youtubeapi.*
import com.example.youtubeapi.base.BaseFragment
import com.example.youtubeapi.databinding.FragmentPlaylistBinding
import com.example.youtubeapi.utils.isOnline


class PlaylistFragment : BaseFragment<FragmentPlaylistBinding, PlaylistViewModel>() {

    private val adapter : PlaylistAdapter by lazy {
        PlaylistAdapter(this ::onClick)

    }

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel :: class.java]
    }


    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlaylistBinding {
       return FragmentPlaylistBinding.inflate(inflater, container, false)
    }

    override fun initView() {

    }

    override fun initListener() {
        binding.noInternet.btnTryAgain.setOnClickListener {
            checkInternet()
        }
    }

    override fun initViewModel() {
        viewModel.getPlaylist().observe(viewLifecycleOwner){
            App.db.dao().insertPlaylist(it)
            adapter.addData(it.items)
        }
        binding.rvPlaylist.adapter = adapter
    }

    override fun checkInternet() {
       val online = isOnline(requireContext())
        binding.rvPlaylist.isVisible = online
        binding.noInternetContainer.isVisible = !online
    }

    private fun onClick(id : String){
        findNavController().navigate(R.id.detailFragment, bundleOf("id" to id))
    }
}