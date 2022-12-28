package com.example.youtubeapi.data

import com.example.youtubeapi.BuildConfig
import com.example.youtubeapi.`object`.Constant
import com.example.youtubeapi.model.Playlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    fun getPlaylist(
        @Query ("part")part : String = Constant.PART,
        @Query ("channelId")channelId : String = Constant.CHANNEL_ID,
        @Query ("maxResults")maxResults : String = Constant.MAX_RESULT,
        @Query ("key")key : String = BuildConfig.API_KEY,
        ) : Call<Playlist>

    @GET("playlistItems")
    fun getPlaylistItems(
        @Query ("part")part : String = Constant.PART,
        @Query ("playlistId")playlistId : String ,
        @Query ("key")key : String = BuildConfig.API_KEY,
        @Query ("maxResults")maxResults : String = Constant.MAX_RESULT
    ): Call<Playlist>
}