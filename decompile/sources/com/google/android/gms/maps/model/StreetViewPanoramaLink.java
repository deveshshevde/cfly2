package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import fg.i;

public class StreetViewPanoramaLink extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaLink> CREATOR = new v();

    /* renamed from: a  reason: collision with root package name */
    public final String f18281a;

    /* renamed from: b  reason: collision with root package name */
    public final float f18282b;

    public StreetViewPanoramaLink(String str, float f2) {
        this.f18281a = str;
        this.f18282b = (((double) f2) <= i.f27244a ? (f2 % 360.0f) + 360.0f : f2) % 360.0f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) obj;
        return this.f18281a.equals(streetViewPanoramaLink.f18281a) && Float.floatToIntBits(this.f18282b) == Float.floatToIntBits(streetViewPanoramaLink.f18282b);
    }

    public int hashCode() {
        return l.a(this.f18281a, Float.valueOf(this.f18282b));
    }

    public String toString() {
        return l.a((Object) this).a("panoId", this.f18281a).a("bearing", Float.valueOf(this.f18282b)).toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 2, this.f18281a, false);
        a.a(parcel, 3, this.f18282b);
        a.a(parcel, a2);
    }
}
