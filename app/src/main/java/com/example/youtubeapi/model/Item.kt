package com.example.youtubeapi.model


data class Item(
    var contentDetails: ContentDetails? = null,
    var etag: String? = null, // 7JpCuc3GPyYuerjQU2Rx7P5yKUk
    var id: String? = null, // PLoSWVnSA9vG8F36IUVWkWIzUN0M9BGG_c
    var kind: String? = null, // youtube#playlist
    var snippet: Snippet? = null
)