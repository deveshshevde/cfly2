package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class j implements Parcelable.Creator<Cap> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        IBinder iBinder = null;
        Float f2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 == 3) {
                iBinder = SafeParcelReader.h(parcel, a2);
            } else if (a3 != 4) {
                SafeParcelReader.r(parcel, a2);
            } else {
                f2 = SafeParcelReader.j(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new Cap(i2, iBinder, f2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new Cap[i2];
    }
}
