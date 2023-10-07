package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzo implements Parcelable.Creator<zzl> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        zzj zzj = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        int i2 = 1;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 == 2) {
                zzj = (zzj) SafeParcelReader.a(parcel, a2, zzj.CREATOR);
            } else if (a3 == 3) {
                iBinder = SafeParcelReader.h(parcel, a2);
            } else if (a3 != 4) {
                SafeParcelReader.r(parcel, a2);
            } else {
                iBinder2 = SafeParcelReader.h(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new zzl(i2, zzj, iBinder, iBinder2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzl[i2];
    }
}
