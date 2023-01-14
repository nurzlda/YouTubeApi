package com.example.youtubeapi.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.youtubeapi.base.BaseViewModel
import com.example.youtubeapi.data.remote.Repository
import com.example.youtubeapi.model.Playlist
import com.example.youtubeapi.network.Resource


class PlaylistViewModel(private val repo: Repository) : BaseViewModel() {
    private val setPlaylistLiveData = MutableLiveData<Playlist>()

    val setPlaylistDB = setPlaylistLiveData.switchMap {
        repo.setPlaylistDB(it)
    }

    val getPlaylist: LiveData<Resource<Playlist>> = repo.getPlaylist()

    val getPlaylistDB: LiveData<Resource<Playlist>> = repo.getPlaylistDB()

    fun setPlaylistDB(playlist: Playlist){
        setPlaylistLiveData.postValue(playlist)
    }
}