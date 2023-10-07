package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class ak implements Parcelable.Creator<zax> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i2 = 0;
        Scope[] scopeArr = null;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 == 2) {
                i3 = SafeParcelReader.d(parcel, a2);
            } else if (a3 == 3) {
                i4 = SafeParcelReader.d(parcel, a2);
            } else if (a3 != 4) {
                SafeParcelReader.r(parcel, a2);
            } else {
                scopeArr = (Scope[]) SafeParcelReader.c(parcel, a2, Scope.CREATOR);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new zax(i2, i3, i4, scopeArr);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zax[i2];
    }
}
