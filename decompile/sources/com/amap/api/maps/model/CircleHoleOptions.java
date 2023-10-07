package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import fg.i;

public class CircleHoleOptions extends BaseHoleOptions implements Parcelable {
    public static final Parcelable.Creator<CircleHoleOptions> CREATOR = new Parcelable.Creator<CircleHoleOptions>() {
        private static CircleHoleOptions a(Parcel parcel) {
            return new CircleHoleOptions(parcel);
        }

        private static CircleHoleOptions[] a(int i2) {
            return new CircleHoleOptions[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public final /* synthetic */ Object[] newArray(int i2) {
            return a(i2);
        }
    };
    private LatLng point = null;
    private double radius = i.f27244a;

    public CircleHoleOptions() {
        this.isPolygonHoleOptions = false;
    }

    protected CircleHoleOptions(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        this.point = new LatLng(readBundle.getDouble("lat"), readBundle.getDouble("lng"));
        this.radius = parcel.readDouble();
    }

    public CircleHoleOptions center(LatLng latLng) {
        this.point = latLng;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public LatLng getCenter() {
        return this.point;
    }

    public double getRadius() {
        return this.radius;
    }

    public CircleHoleOptions radius(double d2) {
        this.radius = d2;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.point;
        if (latLng != null) {
            bundle.putDouble("lat", latLng.latitude);
            bundle.putDouble("lng", this.point.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
    }
}
