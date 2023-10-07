package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class v implements Parcelable.Creator<zzn> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        IBinder iBinder = null;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                str = SafeParcelReader.l(parcel, a2);
            } else if (a3 == 2) {
                z2 = SafeParcelReader.s(parcel, a2);
            } else if (a3 == 3) {
                z3 = SafeParcelReader.s(parcel, a2);
            } else if (a3 == 4) {
                iBinder = SafeParcelReader.h(parcel, a2);
            } else if (a3 != 5) {
                SafeParcelReader.r(parcel, a2);
            } else {
                z4 = SafeParcelReader.s(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new zzn(str, z2, z3, iBinder, z4);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzn[i2];
    }
}
