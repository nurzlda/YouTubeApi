package com.example.youtubeapi

import android.app.Application
import androidx.room.Room
import com.example.youtubeapi.data.remote.networkModule
import com.example.youtubeapi.di.repoModules
import com.example.youtubeapi.di.viewModules
import com.example.youtubeapi.local.AppDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext, AppDataBase::class.java,
            "playlist.db"
        ).build()

        startKoin{
            androidContext(this@App)
            modules(arrayListOf(repoModules, networkModule, viewModules))
        }
    }

    companion object {
        lateinit var db: AppDataBase
    }
}