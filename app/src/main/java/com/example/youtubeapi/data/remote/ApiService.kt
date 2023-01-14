package com.example.youtubeapi.data.remote

import com.example.youtubeapi.BuildConfig
import com.example.youtubeapi.`object`.Constant
import com.example.youtubeapi.model.Playlist
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    suspend fun getPlaylist(
        @Query ("part")part : String = Constant.PART,
        @Query ("channelId")channelId : String = Constant.CHANNEL_ID,
        @Query ("maxResults")maxResults : String = Constant.MAX_RESULT,
        @Query ("key")key : String = BuildConfig.API_KEY,
        ): Response<Playlist>

    @GET("playlistItems")
    suspend fun getPlaylistItems(
        @Query ("part")part : String = Constant.PART,
        @Query ("playlistId")playlistId : String ,
        @Query ("key")key : String = BuildConfig.API_KEY,
        @Query ("maxResults")maxResults : String = Constant.MAX_RESULT
    ): Response<Playlist>
}