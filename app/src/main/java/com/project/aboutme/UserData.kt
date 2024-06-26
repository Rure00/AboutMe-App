package com.project.aboutme

import android.os.Parcel
import android.os.Parcelable

data class UserData(
    var name: String,
    var id: String,
    var pwd: String
): Parcelable {
    constructor(parcel: Parcel): this(
        name = parcel.readString() ?: "",
        id = parcel.readString() ?: "",
        pwd = parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(id)
        parcel.writeString(pwd)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserData> {
        override fun createFromParcel(parcel: Parcel): UserData {
            return UserData(parcel)
        }

        override fun newArray(size: Int): Array<UserData?> {
            return arrayOfNulls(size)
        }
    }
}
