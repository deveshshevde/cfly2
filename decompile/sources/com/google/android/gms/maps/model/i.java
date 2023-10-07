package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class i implements Parcelable.Creator<CameraPosition> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        float f2 = 0.0f;
        LatLng latLng = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                latLng = (LatLng) SafeParcelReader.a(parcel, a2, LatLng.CREATOR);
            } else if (a3 == 3) {
                f2 = SafeParcelReader.c(parcel, a2);
            } else if (a3 == 4) {
                f3 = SafeParcelReader.c(parcel, a2);
            } else if (a3 != 5) {
                SafeParcelReader.r(parcel, a2);
            } else {
                f4 = SafeParcelReader.c(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new CameraPosition(latLng, f2, f3, f4);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new CameraPosition[i2];
    }
}
