package fr.sadok.fizzbuzz.domain.entity

import android.os.Parcel
import android.os.Parcelable

data class FizzBuzzEntity(var number1: Int,
                          var number2: Int,
                          var limit: Int,
                          var text1: String,
                          var text2: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()?: "",
        parcel.readString()?: "",
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(number1)
        parcel.writeInt(number2)
        parcel.writeInt(limit)
        parcel.writeString(text1)
        parcel.writeString(text2)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FizzBuzzEntity> {
        override fun createFromParcel(parcel: Parcel): FizzBuzzEntity {
            return FizzBuzzEntity(parcel)
        }

        override fun newArray(size: Int): Array<FizzBuzzEntity?> {
            return arrayOfNulls(size)
        }
    }
}
