package com.example.youtubeapi.detail


import com.example.youtubeapi.base.BaseViewModel
import com.example.youtubeapi.data.remote.Repository

class DetailViewModel(private val repository: Repository) : BaseViewModel(){
    fun getPlaylistItems(id : String) = repository.getPlaylistItems(id)
}