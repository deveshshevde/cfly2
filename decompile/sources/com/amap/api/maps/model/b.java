package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

final class b implements Parcelable.Creator<Tile> {
    b() {
    }

    private static Tile a(Parcel parcel) {
        return new Tile(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray(), parcel.readInt() == 1);
    }

    private static Tile[] a(int i2) {
        return new Tile[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return a(i2);
    }
}
