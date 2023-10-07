package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.zat;

public final class h implements Parcelable.Creator<zai> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i2 = 0;
        zat zat = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 != 2) {
                SafeParcelReader.r(parcel, a2);
            } else {
                zat = (zat) SafeParcelReader.a(parcel, a2, zat.CREATOR);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new zai(i2, zat);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zai[i2];
    }
}
