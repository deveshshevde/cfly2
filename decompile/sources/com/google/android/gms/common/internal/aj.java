package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class aj implements Parcelable.Creator<zav> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        IBinder iBinder = null;
        ConnectionResult connectionResult = null;
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 == 2) {
                iBinder = SafeParcelReader.h(parcel, a2);
            } else if (a3 == 3) {
                connectionResult = (ConnectionResult) SafeParcelReader.a(parcel, a2, ConnectionResult.CREATOR);
            } else if (a3 == 4) {
                z2 = SafeParcelReader.s(parcel, a2);
            } else if (a3 != 5) {
                SafeParcelReader.r(parcel, a2);
            } else {
                z3 = SafeParcelReader.s(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new zav(i2, iBinder, connectionResult, z2, z3);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zav[i2];
    }
}
