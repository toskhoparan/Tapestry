package com.mt.feedlin.ui.feed

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by max on 02-Jun-17.
 */
class FeedsState() : FeedsContract.State {

    override var itemPosition: Int? = 0

    constructor(parcel: Parcel) : this() {
        itemPosition = parcel.readInt()
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        itemPosition?.let { dest?.writeInt(it) }
    }

    override fun describeContents() = 0

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<FeedsState> = object : Parcelable.Creator<FeedsState> {
            override fun createFromParcel(source: Parcel): FeedsState{
                return FeedsState(source)
            }

            override fun newArray(size: Int): Array<FeedsState?> {
                return arrayOfNulls(size)
            }
        }
    }
}