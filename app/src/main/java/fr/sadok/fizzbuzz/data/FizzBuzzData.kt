package fr.sadok.fizzbuzz.data

import android.os.Parcel
import android.os.Parcelable

data class FizzBuzzData(var number1: Int,
                        var number2: Int,
                        var text1: String,
                        var text2: String,
                        var limit: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(number1)
        parcel.writeInt(number2)
        parcel.writeString(text1)
        parcel.writeString(text2)
        parcel.writeInt(limit)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FizzBuzzData> {
        override fun createFromParcel(parcel: Parcel): FizzBuzzData {
            return FizzBuzzData(parcel)
        }

        override fun newArray(size: Int): Array<FizzBuzzData?> {
            return arrayOfNulls(size)
        }
    }
}
