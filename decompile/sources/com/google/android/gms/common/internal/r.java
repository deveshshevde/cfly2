package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class r implements Parcelable.Creator<ClientIdentity> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i2 = 0;
        String str = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 != 2) {
                SafeParcelReader.r(parcel, a2);
            } else {
                str = SafeParcelReader.l(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new ClientIdentity(i2, str);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new ClientIdentity[i2];
    }
}
