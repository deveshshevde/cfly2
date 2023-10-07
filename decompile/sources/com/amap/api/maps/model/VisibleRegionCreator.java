package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

public class VisibleRegionCreator implements Parcelable.Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(VisibleRegion visibleRegion, Parcel parcel, int i2) {
        parcel.writeInt(visibleRegion.a());
        parcel.writeParcelable(visibleRegion.nearLeft, i2);
        parcel.writeParcelable(visibleRegion.nearRight, i2);
        parcel.writeParcelable(visibleRegion.farLeft, i2);
        parcel.writeParcelable(visibleRegion.farRight, i2);
        parcel.writeParcelable(visibleRegion.latLngBounds, i2);
    }

    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds;
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        LatLng latLng4;
        int readInt = parcel.readInt();
        try {
            latLng4 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            try {
                latLng3 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                try {
                    latLng2 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                } catch (BadParcelableException e2) {
                    e = e2;
                    latLng2 = null;
                    latLng = latLng2;
                    e.printStackTrace();
                    latLngBounds = null;
                    return new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
                }
            } catch (BadParcelableException e3) {
                e = e3;
                latLng3 = null;
                latLng2 = latLng3;
                latLng = latLng2;
                e.printStackTrace();
                latLngBounds = null;
                return new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
            }
            try {
                latLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                try {
                    latLngBounds = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
                } catch (BadParcelableException e4) {
                    e = e4;
                    e.printStackTrace();
                    latLngBounds = null;
                    return new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
                }
            } catch (BadParcelableException e5) {
                e = e5;
                latLng = null;
                e.printStackTrace();
                latLngBounds = null;
                return new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
            }
        } catch (BadParcelableException e6) {
            e = e6;
            latLng4 = null;
            latLng3 = null;
            latLng2 = latLng3;
            latLng = latLng2;
            e.printStackTrace();
            latLngBounds = null;
            return new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        return new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
    }

    public VisibleRegion[] newArray(int i2) {
        return new VisibleRegion[i2];
    }
}
