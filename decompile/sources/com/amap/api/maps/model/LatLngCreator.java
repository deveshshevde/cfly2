package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public class LatLngCreator implements Parcelable.Creator<LatLng> {
    public static final int CONTENT_DESCRIPTION = 0;

    public LatLng createFromParcel(Parcel parcel) {
        return new LatLng(parcel.readDouble(), parcel.readDouble());
    }

    public LatLng[] newArray(int i2) {
        return new LatLng[i2];
    }
}
