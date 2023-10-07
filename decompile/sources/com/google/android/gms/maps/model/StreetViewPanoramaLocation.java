package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public class StreetViewPanoramaLocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaLocation> CREATOR = new w();

    /* renamed from: a  reason: collision with root package name */
    public final StreetViewPanoramaLink[] f18283a;

    /* renamed from: b  reason: collision with root package name */
    public final LatLng f18284b;

    /* renamed from: c  reason: collision with root package name */
    public final String f18285c;

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this.f18283a = streetViewPanoramaLinkArr;
        this.f18284b = latLng;
        this.f18285c = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
        return this.f18285c.equals(streetViewPanoramaLocation.f18285c) && this.f18284b.equals(streetViewPanoramaLocation.f18284b);
    }

    public int hashCode() {
        return l.a(this.f18284b, this.f18285c);
    }

    public String toString() {
        return l.a((Object) this).a("panoId", this.f18285c).a("position", this.f18284b.toString()).toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 2, (T[]) this.f18283a, i2, false);
        a.a(parcel, 3, (Parcelable) this.f18284b, i2, false);
        a.a(parcel, 4, this.f18285c, false);
        a.a(parcel, a2);
    }
}
