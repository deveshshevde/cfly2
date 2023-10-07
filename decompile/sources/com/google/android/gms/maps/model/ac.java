package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class ac implements Parcelable.Creator<TileOverlayOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        IBinder iBinder = null;
        boolean z2 = false;
        float f2 = 0.0f;
        boolean z3 = true;
        float f3 = 0.0f;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                iBinder = SafeParcelReader.h(parcel, a2);
            } else if (a3 == 3) {
                z2 = SafeParcelReader.s(parcel, a2);
            } else if (a3 == 4) {
                f2 = SafeParcelReader.c(parcel, a2);
            } else if (a3 == 5) {
                z3 = SafeParcelReader.s(parcel, a2);
            } else if (a3 != 6) {
                SafeParcelReader.r(parcel, a2);
            } else {
                f3 = SafeParcelReader.c(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new TileOverlayOptions(iBinder, z2, f2, z3, f3);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new TileOverlayOptions[i2];
    }
}
