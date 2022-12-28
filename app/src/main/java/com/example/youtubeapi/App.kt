package com.example.youtubeapi

import android.app.Application
import androidx.room.Room
import com.example.youtubeapi.local.AppDataBase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, AppDataBase ::class.java,
            "playlist.db").allowMainThreadQueries().build()
    }

    companion object{
        lateinit var db: AppDataBase
    }


}