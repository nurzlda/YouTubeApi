package com.example.youtubeapi.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Playlist(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var etag: String? = null, // 63AGyPEfefXwgymKfyOyTryAQeU
    var items: List<Item>? = null,
    var kind: String? = null, // youtube#playlistListResponse
    var nextPageToken: String? = null, // CAcQAA
    var pageInfo: PageInfo? = null
)