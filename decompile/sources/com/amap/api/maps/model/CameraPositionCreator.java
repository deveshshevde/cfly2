package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CameraPositionCreator implements Parcelable.Creator<CameraPosition> {
    public CameraPosition createFromParcel(Parcel parcel) {
        float readFloat = parcel.readFloat();
        float readFloat2 = parcel.readFloat();
        float readFloat3 = parcel.readFloat();
        float readFloat4 = parcel.readFloat();
        return new CameraPosition(new LatLng((double) readFloat2, (double) readFloat3), parcel.readFloat(), readFloat4, readFloat);
    }

    public CameraPosition[] newArray(int i2) {
        return new CameraPosition[i2];
    }
}
