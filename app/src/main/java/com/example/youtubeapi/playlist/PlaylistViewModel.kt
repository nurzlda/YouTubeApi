package com.example.youtubeapi.playlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi.base.BaseViewModel
import com.example.youtubeapi.data.ApiService
import com.example.youtubeapi.data.RetrofitClient
import com.example.youtubeapi.model.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel : BaseViewModel() {

    private val apiService: ApiService by lazy{

        RetrofitClient.create()
    }

    fun getPlaylist() : LiveData<Playlist>{

        val data = MutableLiveData<Playlist>()

        apiService.getPlaylist().enqueue(object : Callback<Playlist>{
            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {

                if (response.isSuccessful){
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<Playlist>, t: Throwable) {
                Log.e("ololo", "onFailure: " + t.message )
            }

        })
        return data
    }
}