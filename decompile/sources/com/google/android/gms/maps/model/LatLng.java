package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class LatLng extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLng> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    public final double f18225a;

    /* renamed from: b  reason: collision with root package name */
    public final double f18226b;

    public LatLng(double d2, double d3) {
        this.f18226b = (-180.0d > d3 || d3 >= 180.0d) ? ((((d3 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d : d3;
        this.f18225a = Math.max(-90.0d, Math.min(90.0d, d2));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.f18225a) == Double.doubleToLongBits(latLng.f18225a) && Double.doubleToLongBits(this.f18226b) == Double.doubleToLongBits(latLng.f18226b);
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f18225a);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f18226b);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public final String toString() {
        double d2 = this.f18225a;
        double d3 = this.f18226b;
        StringBuilder sb = new StringBuilder(60);
        sb.append("lat/lng: (");
        sb.append(d2);
        sb.append(",");
        sb.append(d3);
        sb.append(")");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 2, this.f18225a);
        a.a(parcel, 3, this.f18226b);
        a.a(parcel, a2);
    }
}
