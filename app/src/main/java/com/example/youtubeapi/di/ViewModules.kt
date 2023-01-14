package com.example.youtubeapi.di


import com.example.youtubeapi.detail.DetailViewModel
import com.example.youtubeapi.ui.playlist.PlaylistViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {
    viewModel {
        PlaylistViewModel(get())
    }

    viewModel {
        DetailViewModel(get())
    }
}