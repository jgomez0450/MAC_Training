package com.example.user.activitylifecycleandintent.model

import android.os.Parcel
import android.os.Parcelable

data class PersonP(var name: String, var age: String, var gender: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()
    )

    companion object CREATOR : Parcelable.Creator<PersonP> {
        override fun createFromParcel(parcel: Parcel): PersonP {
            return PersonP(parcel)
        }

        override fun newArray(size: Int): Array<PersonP?> {
            return arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(name)
        parcel.writeString(age)
        parcel.writeString(gender)
    }
}