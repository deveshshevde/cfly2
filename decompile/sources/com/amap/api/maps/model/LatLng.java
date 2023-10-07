package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.AMapException;

public final class LatLng implements Parcelable, Cloneable {
    public static final LatLngCreator CREATOR = new LatLngCreator();
    public final double latitude;
    public final double longitude;

    public LatLng(double d2, double d3) {
        this(d2, d3, true);
    }

    public LatLng(double d2, double d3, boolean z2) {
        if (z2) {
            this.longitude = (-180.0d > d3 || d3 >= 180.0d) ? ((((d3 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d : d3;
            if (d2 < -90.0d || d2 > 90.0d) {
                try {
                    throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
                } catch (AMapException e2) {
                    e2.printStackTrace();
                }
            }
            this.latitude = Math.max(-90.0d, Math.min(90.0d, d2));
            return;
        }
        this.latitude = d2;
        this.longitude = d3;
    }

    public final LatLng clone() {
        return new LatLng(this.latitude, this.longitude);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(latLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(latLng.longitude);
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public final String toString() {
        return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
    }
}
