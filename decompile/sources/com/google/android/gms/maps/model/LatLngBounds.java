package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    public final LatLng f18227a;

    /* renamed from: b  reason: collision with root package name */
    public final LatLng f18228b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private double f18229a = Double.POSITIVE_INFINITY;

        /* renamed from: b  reason: collision with root package name */
        private double f18230b = Double.NEGATIVE_INFINITY;

        /* renamed from: c  reason: collision with root package name */
        private double f18231c = Double.NaN;

        /* renamed from: d  reason: collision with root package name */
        private double f18232d = Double.NaN;

        public final a a(LatLng latLng) {
            this.f18229a = Math.min(this.f18229a, latLng.f18225a);
            this.f18230b = Math.max(this.f18230b, latLng.f18225a);
            double d2 = latLng.f18226b;
            if (Double.isNaN(this.f18231c)) {
                this.f18231c = d2;
            } else {
                double d3 = this.f18231c;
                double d4 = this.f18232d;
                boolean z2 = false;
                if (d3 > d4 ? d3 <= d2 || d2 <= d4 : d3 <= d2 && d2 <= d4) {
                    z2 = true;
                }
                if (!z2) {
                    if (LatLngBounds.c(d3, d2) < LatLngBounds.d(this.f18232d, d2)) {
                        this.f18231c = d2;
                    }
                }
                return this;
            }
            this.f18232d = d2;
            return this;
        }

        public final LatLngBounds a() {
            m.b(!Double.isNaN(this.f18231c), "no included points");
            return new LatLngBounds(new LatLng(this.f18229a, this.f18231c), new LatLng(this.f18230b, this.f18232d));
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        m.a(latLng, (Object) "null southwest");
        m.a(latLng2, (Object) "null northeast");
        m.a(latLng2.f18225a >= latLng.f18225a, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(latLng.f18225a), Double.valueOf(latLng2.f18225a));
        this.f18227a = latLng;
        this.f18228b = latLng2;
    }

    /* access modifiers changed from: private */
    public static double c(double d2, double d3) {
        return ((d2 - d3) + 360.0d) % 360.0d;
    }

    /* access modifiers changed from: private */
    public static double d(double d2, double d3) {
        return ((d3 - d2) + 360.0d) % 360.0d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.f18227a.equals(latLngBounds.f18227a) && this.f18228b.equals(latLngBounds.f18228b);
    }

    public final int hashCode() {
        return l.a(this.f18227a, this.f18228b);
    }

    public final String toString() {
        return l.a((Object) this).a("southwest", this.f18227a).a("northeast", this.f18228b).toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 2, (Parcelable) this.f18227a, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 3, (Parcelable) this.f18228b, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2);
    }
}
