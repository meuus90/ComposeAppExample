package com.example.composeapp.di.module

import com.example.composeapp.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity
}