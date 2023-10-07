package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class ar implements Parcelable.Creator<RootTelemetryConfiguration> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 == 2) {
                z2 = SafeParcelReader.s(parcel, a2);
            } else if (a3 == 3) {
                z3 = SafeParcelReader.s(parcel, a2);
            } else if (a3 == 4) {
                i3 = SafeParcelReader.d(parcel, a2);
            } else if (a3 != 5) {
                SafeParcelReader.r(parcel, a2);
            } else {
                i4 = SafeParcelReader.d(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new RootTelemetryConfiguration(i2, z2, z3, i3, i4);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new RootTelemetryConfiguration[i2];
    }
}
