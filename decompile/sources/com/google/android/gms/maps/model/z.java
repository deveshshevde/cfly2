package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class z implements Parcelable.Creator<Tile> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i2 = 0;
        byte[] bArr = null;
        int i3 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 == 3) {
                i3 = SafeParcelReader.d(parcel, a2);
            } else if (a3 != 4) {
                SafeParcelReader.r(parcel, a2);
            } else {
                bArr = SafeParcelReader.t(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new Tile(i2, i3, bArr);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new Tile[i2];
    }
}
