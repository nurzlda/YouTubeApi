package com.example.youtubeapi.data.remote


import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtubeapi.App
import com.example.youtubeapi.model.Playlist
import com.example.youtubeapi.network.Resource
import kotlinx.coroutines.Dispatchers

class Repository(private val apiService: ApiService) {
    fun getPlaylist(): LiveData<Resource<Playlist>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val result = apiService.getPlaylist()

        if (result.isSuccessful) {
            emit(Resource.success(result.body()))
        } else {
            emit(Resource.error(result.message()))
        }
    }

    fun getPlaylistItems(playlistId: String): LiveData<Resource<Playlist>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val result = apiService.getPlaylistItems(playlistId = playlistId)
            if (result.isSuccessful) {
                emit(Resource.success(result.body()))
            } else {
                emit(Resource.error(result.message()))
            }
        }

    fun setPlaylistDB(playlist: Playlist): LiveData<Resource<Boolean>> = liveData(Dispatchers.IO){
        emit(Resource.loading())
        App.db.dao().insertPlaylist(playlist)
        emit(Resource.success(true))
    }

    fun getPlaylistDB(): LiveData<Resource<Playlist>> = liveData(Dispatchers.IO){
        emit(Resource.loading())
        val result = App.db.dao().getPlaylist()
        if (result != null){
            emit(Resource.success(result))
        }else{
            emit(Resource.error("Empty data"))
        }
    }
}