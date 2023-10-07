package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class VisibleRegion extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VisibleRegion> CREATOR = new ad();

    /* renamed from: a  reason: collision with root package name */
    public final LatLng f18303a;

    /* renamed from: b  reason: collision with root package name */
    public final LatLng f18304b;

    /* renamed from: c  reason: collision with root package name */
    public final LatLng f18305c;

    /* renamed from: d  reason: collision with root package name */
    public final LatLng f18306d;

    /* renamed from: e  reason: collision with root package name */
    public final LatLngBounds f18307e;

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.f18303a = latLng;
        this.f18304b = latLng2;
        this.f18305c = latLng3;
        this.f18306d = latLng4;
        this.f18307e = latLngBounds;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return this.f18303a.equals(visibleRegion.f18303a) && this.f18304b.equals(visibleRegion.f18304b) && this.f18305c.equals(visibleRegion.f18305c) && this.f18306d.equals(visibleRegion.f18306d) && this.f18307e.equals(visibleRegion.f18307e);
    }

    public final int hashCode() {
        return l.a(this.f18303a, this.f18304b, this.f18305c, this.f18306d, this.f18307e);
    }

    public final String toString() {
        return l.a((Object) this).a("nearLeft", this.f18303a).a("nearRight", this.f18304b).a("farLeft", this.f18305c).a("farRight", this.f18306d).a("latLngBounds", this.f18307e).toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 2, (Parcelable) this.f18303a, i2, false);
        a.a(parcel, 3, (Parcelable) this.f18304b, i2, false);
        a.a(parcel, 4, (Parcelable) this.f18305c, i2, false);
        a.a(parcel, 5, (Parcelable) this.f18306d, i2, false);
        a.a(parcel, 6, (Parcelable) this.f18307e, i2, false);
        a.a(parcel, a2);
    }
}
