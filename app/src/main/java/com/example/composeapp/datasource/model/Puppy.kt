package com.example.composeapp.datasource.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Puppy(
    val id: Int,
    val title: String,
    val description: String,
    val puppyImageId: Int = 0
) : Parcelable