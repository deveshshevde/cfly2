package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fg.i;

public class StreetViewPanoramaOrientation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOrientation> CREATOR = new x();

    /* renamed from: a  reason: collision with root package name */
    public final float f18286a;

    /* renamed from: b  reason: collision with root package name */
    public final float f18287b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public float f18288a;

        /* renamed from: b  reason: collision with root package name */
        public float f18289b;

        public final a a(float f2) {
            this.f18289b = f2;
            return this;
        }

        public final StreetViewPanoramaOrientation a() {
            return new StreetViewPanoramaOrientation(this.f18289b, this.f18288a);
        }

        public final a b(float f2) {
            this.f18288a = f2;
            return this;
        }
    }

    public StreetViewPanoramaOrientation(float f2, float f3) {
        boolean z2 = -90.0f <= f2 && f2 <= 90.0f;
        StringBuilder sb = new StringBuilder(62);
        sb.append("Tilt needs to be between -90 and 90 inclusive: ");
        sb.append(f2);
        m.a(z2, (Object) sb.toString());
        this.f18286a = f2 + 0.0f;
        this.f18287b = (((double) f3) <= i.f27244a ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaOrientation)) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) obj;
        return Float.floatToIntBits(this.f18286a) == Float.floatToIntBits(streetViewPanoramaOrientation.f18286a) && Float.floatToIntBits(this.f18287b) == Float.floatToIntBits(streetViewPanoramaOrientation.f18287b);
    }

    public int hashCode() {
        return l.a(Float.valueOf(this.f18286a), Float.valueOf(this.f18287b));
    }

    public String toString() {
        return l.a((Object) this).a("tilt", Float.valueOf(this.f18286a)).a("bearing", Float.valueOf(this.f18287b)).toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 2, this.f18286a);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 3, this.f18287b);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2);
    }
}
