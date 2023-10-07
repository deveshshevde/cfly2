package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class bb implements Parcelable.Creator<zzj> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        Bundle bundle = null;
        Feature[] featureArr = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                bundle = SafeParcelReader.g(parcel, a2);
            } else if (a3 == 2) {
                featureArr = (Feature[]) SafeParcelReader.c(parcel, a2, Feature.CREATOR);
            } else if (a3 == 3) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 != 4) {
                SafeParcelReader.r(parcel, a2);
            } else {
                connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) SafeParcelReader.a(parcel, a2, ConnectionTelemetryConfiguration.CREATOR);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new zzj(bundle, featureArr, i2, connectionTelemetryConfiguration);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzj[i2];
    }
}
