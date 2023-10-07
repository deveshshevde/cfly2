package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

public class LatLngBoundsCreator implements Parcelable.Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(LatLngBounds latLngBounds, Parcel parcel, int i2) {
        parcel.writeInt(latLngBounds.a());
        parcel.writeParcelable(latLngBounds.southwest, i2);
        parcel.writeParcelable(latLngBounds.northeast, i2);
    }

    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        int readInt = parcel.readInt();
        LatLng latLng2 = null;
        try {
            latLng = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            try {
                latLng2 = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            } catch (BadParcelableException e2) {
                e = e2;
                e.printStackTrace();
                return new LatLngBounds(readInt, latLng, latLng2);
            }
        } catch (BadParcelableException e3) {
            e = e3;
            latLng = null;
            e.printStackTrace();
            return new LatLngBounds(readInt, latLng, latLng2);
        }
        return new LatLngBounds(readInt, latLng, latLng2);
    }

    public LatLngBounds[] newArray(int i2) {
        return new LatLngBounds[i2];
    }
}
