package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class c implements Parcelable.Creator<zac> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i2 = 0;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 == 2) {
                str = SafeParcelReader.l(parcel, a2);
            } else if (a3 != 3) {
                SafeParcelReader.r(parcel, a2);
            } else {
                i3 = SafeParcelReader.d(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new zac(i2, str, i3);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zac[i2];
    }
}
