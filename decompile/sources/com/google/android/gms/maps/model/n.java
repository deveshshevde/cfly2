package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import fg.i;

public final class n implements Parcelable.Creator<LatLng> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        double d2 = i.f27244a;
        double d3 = 0.0d;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                d2 = SafeParcelReader.b(parcel, a2);
            } else if (a3 != 3) {
                SafeParcelReader.r(parcel, a2);
            } else {
                d3 = SafeParcelReader.b(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new LatLng(d2, d3);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new LatLng[i2];
    }
}
