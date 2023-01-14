package com.example.youtubeapi.detail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.youtubeapi.R
import com.example.youtubeapi.base.BaseFragment
import com.example.youtubeapi.databinding.FragmentDetailBinding
import com.example.youtubeapi.model.Item
import com.example.youtubeapi.network.Status
import com.example.youtubeapi.ui.playlist.PlaylistAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {
    private val adapter: PlaylistAdapter by lazy {
        PlaylistAdapter(this::onClick, requireContext())
    }

    override val viewModel: DetailViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        val item = arguments?.getSerializable("item") as Item
        viewModel.getPlaylistItems(item.id.toString()).observe(viewLifecycleOwner) {
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
                    Log.e("ololo", "initViewModel: " + it.msg)
                }
            }
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }

        binding.rvPlaylist.adapter = adapter
        val count = item.contentDetails?.itemCount
        binding.tvVideoCount.text = getString(R.string.video_count, count)
        binding.tvPlaylistName.text = item.snippet?.title
    }

    private fun onClick(item: Item) {}
}