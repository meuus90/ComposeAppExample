package com.example.composeapp.presentation.viewmodel.puppy

import com.example.composeapp.datasource.model.Puppy
import com.example.composeapp.presentation.viewmodel.SharedViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPuppyViewModel
@Inject
constructor() : SharedViewModel<Puppy>()