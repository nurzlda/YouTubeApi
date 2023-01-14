package com.example.youtubeapi.ui.playlist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.youtubeapi.*
import com.example.youtubeapi.base.BaseFragment
import com.example.youtubeapi.databinding.FragmentPlaylistBinding
import com.example.youtubeapi.model.Item
import com.example.youtubeapi.network.Status
import com.example.youtubeapi.utils.isOnline
import org.koin.androidx.viewmodel.ext.android.viewModel


class PlaylistFragment : BaseFragment<FragmentPlaylistBinding, PlaylistViewModel>() {
    private val adapter: PlaylistAdapter by lazy {
        PlaylistAdapter(this::onClick, requireContext())
    }

    override val viewModel: PlaylistViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlaylistBinding {
        return FragmentPlaylistBinding.inflate(inflater, container, false)
    }

    override fun initView() {}

    override fun initListener() {
        binding.noInternet.btnTryAgain.setOnClickListener {
            checkInternet()
        }
    }

    override fun initViewModel() {
        viewModel.getPlaylistDB.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    viewModel.loading.value = false
                    adapter.addData(it.data?.items)
                }
                Status.LOADING -> {
                    viewModel.loading.value = true
                }
                Status.ERROR -> {
                    viewModel.loading.value = false
                }
            }
        }

        viewModel.getPlaylist.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    viewModel.loading.value = false
                    adapter.addData(it.data?.items)
                    it.data?.let { it1 -> viewModel.setPlaylistDB(it1) }
                }
                Status.LOADING -> {
                    viewModel.loading.value = true
                }
                Status.ERROR -> {
                    viewModel.loading.value = false
                }
            }
        }

        viewModel.setPlaylistDB.observe(viewLifecycleOwner) {
            Log.e("ololo", "setPlaylist: " + it.data)
        }
        viewModel.loading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
        binding.rvPlaylist.adapter = adapter
    }

    override fun checkInternet() {
        val online = isOnline(requireContext())
        binding.rvPlaylist.isVisible = online
        binding.noInternetContainer.isVisible = !online
    }

    private fun onClick(item: Item) {
        findNavController().navigate(R.id.detailFragment, bundleOf("item" to item))
    }
}