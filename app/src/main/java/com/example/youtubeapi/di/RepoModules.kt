package com.example.youtubeapi.di

import com.example.youtubeapi.data.remote.Repository
import org.koin.dsl.module

val repoModules = module {
    single { Repository(get()) }
}