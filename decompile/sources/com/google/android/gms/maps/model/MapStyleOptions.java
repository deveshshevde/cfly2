package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class MapStyleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MapStyleOptions> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    private static final String f18233a = "MapStyleOptions";

    /* renamed from: b  reason: collision with root package name */
    private String f18234b;

    public MapStyleOptions(String str) {
        this.f18234b = str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 2, this.f18234b, false);
        a.a(parcel, a2);
    }
}
