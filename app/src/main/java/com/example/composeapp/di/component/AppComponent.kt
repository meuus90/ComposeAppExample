package com.example.composeapp.di.component

import android.app.Application
import com.example.composeapp.ComposeApp
import com.example.composeapp.di.module.AppModule
import com.example.composeapp.di.module.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        MainActivityModule::class,
    ]
)

interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }

    fun inject(app: ComposeApp)
}