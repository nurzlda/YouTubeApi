package com.example.youtubeapi.model

data class Snippet(
    var channelId: String? = null, // UCX6OQ3DkcsbYNE6H8uQQuVA
    var channelTitle: String? = null, // MrBeast
    var description: String? = null,
    var localized: Localized? = null,
    var publishedAt: String? = null, // 2022-12-05T20:34:42Z
    var thumbnails: Thumbnails? = null,
    var title: String? = null // Vidéos
)