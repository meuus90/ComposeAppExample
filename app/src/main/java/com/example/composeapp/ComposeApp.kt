package com.example.composeapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ComposeApp : Application() {

    override fun onCreate() {
        super.onCreate()

//        DaggerComposeApp_HiltComponents_ApplicationC.builder().build().injectComposeApp(this)
    }
}