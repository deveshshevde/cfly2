package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class x implements Parcelable.Creator<zzq> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        boolean z2 = false;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                z2 = SafeParcelReader.s(parcel, a2);
            } else if (a3 == 2) {
                str = SafeParcelReader.l(parcel, a2);
            } else if (a3 != 3) {
                SafeParcelReader.r(parcel, a2);
            } else {
                i2 = SafeParcelReader.d(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new zzq(z2, str, i2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzq[i2];
    }
}
