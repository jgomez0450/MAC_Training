package com.example.user.activitylifecycleandintent.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * An alternative way to define a Parcelable class. @Parcelize generates the implementation for you.
 */

@Parcelize
data class PersonPParcelize(var name: String, var age: String, var gender: String) : Parcelable