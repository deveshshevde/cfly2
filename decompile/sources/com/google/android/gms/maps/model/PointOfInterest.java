package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class PointOfInterest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PointOfInterest> CREATOR = new r();

    /* renamed from: a  reason: collision with root package name */
    public final LatLng f18252a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18253b;

    /* renamed from: c  reason: collision with root package name */
    public final String f18254c;

    public PointOfInterest(LatLng latLng, String str, String str2) {
        this.f18252a = latLng;
        this.f18253b = str;
        this.f18254c = str2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 2, (Parcelable) this.f18252a, i2, false);
        a.a(parcel, 3, this.f18253b, false);
        a.a(parcel, 4, this.f18254c, false);
        a.a(parcel, a2);
    }
}
