package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TileProjectionCreator implements Parcelable.Creator<TileProjection> {
    public TileProjection createFromParcel(Parcel parcel) {
        return new TileProjection(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    public TileProjection[] newArray(int i2) {
        return new TileProjection[i2];
    }
}
