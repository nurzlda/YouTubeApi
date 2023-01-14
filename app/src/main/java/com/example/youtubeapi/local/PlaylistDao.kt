package com.example.youtubeapi.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.youtubeapi.model.Playlist

@Dao
interface PlaylistDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertPlaylist(playlist: Playlist)

    @Query("SElECT * FROM playlist")
    suspend fun getPlaylist(): Playlist?
}