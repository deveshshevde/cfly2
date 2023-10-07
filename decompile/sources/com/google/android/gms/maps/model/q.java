package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class q implements Parcelable.Creator<PatternItem> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i2 = 0;
        Float f2 = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 != 3) {
                SafeParcelReader.r(parcel, a2);
            } else {
                f2 = SafeParcelReader.j(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new PatternItem(i2, f2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new PatternItem[i2];
    }
}
