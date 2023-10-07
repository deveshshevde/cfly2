package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class as implements Parcelable.Creator<zzaj> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a2) != 1) {
                SafeParcelReader.r(parcel, a2);
            } else {
                i2 = SafeParcelReader.d(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new zzaj(i2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzaj[i2];
    }
}
