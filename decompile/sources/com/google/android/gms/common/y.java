package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class y implements Parcelable.Creator<zzs> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        boolean z2 = false;
        String str = null;
        IBinder iBinder = null;
        boolean z3 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                str = SafeParcelReader.l(parcel, a2);
            } else if (a3 == 2) {
                iBinder = SafeParcelReader.h(parcel, a2);
            } else if (a3 == 3) {
                z2 = SafeParcelReader.s(parcel, a2);
            } else if (a3 != 4) {
                SafeParcelReader.r(parcel, a2);
            } else {
                z3 = SafeParcelReader.s(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new zzs(str, iBinder, z2, z3);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzs[i2];
    }
}
