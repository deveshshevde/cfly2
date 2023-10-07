package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzab implements Parcelable.Creator<zzac> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        Status status = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a2) != 1) {
                SafeParcelReader.r(parcel, a2);
            } else {
                status = (Status) SafeParcelReader.a(parcel, a2, Status.CREATOR);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new zzac(status);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzac[i2];
    }
}
