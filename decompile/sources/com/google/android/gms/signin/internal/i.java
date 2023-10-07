package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.zav;

public final class i implements Parcelable.Creator<zak> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        ConnectionResult connectionResult = null;
        zav zav = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 == 2) {
                connectionResult = (ConnectionResult) SafeParcelReader.a(parcel, a2, ConnectionResult.CREATOR);
            } else if (a3 != 3) {
                SafeParcelReader.r(parcel, a2);
            } else {
                zav = (zav) SafeParcelReader.a(parcel, a2, zav.CREATOR);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new zak(i2, connectionResult, zav);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zak[i2];
    }
}
