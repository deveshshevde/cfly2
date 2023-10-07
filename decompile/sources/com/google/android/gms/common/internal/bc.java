package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class bc implements Parcelable.Creator<ConnectionTelemetryConfiguration> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArr = null;
        int[] iArr2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) SafeParcelReader.a(parcel, a2, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    z2 = SafeParcelReader.s(parcel, a2);
                    break;
                case 3:
                    z3 = SafeParcelReader.s(parcel, a2);
                    break;
                case 4:
                    iArr = SafeParcelReader.w(parcel, a2);
                    break;
                case 5:
                    i2 = SafeParcelReader.d(parcel, a2);
                    break;
                case 6:
                    iArr2 = SafeParcelReader.w(parcel, a2);
                    break;
                default:
                    SafeParcelReader.r(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, z2, z3, iArr, i2, iArr2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new ConnectionTelemetryConfiguration[i2];
    }
}
