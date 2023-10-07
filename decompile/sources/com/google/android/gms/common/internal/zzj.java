package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new bb();

    /* renamed from: a  reason: collision with root package name */
    Bundle f17880a;

    /* renamed from: b  reason: collision with root package name */
    Feature[] f17881b;

    /* renamed from: c  reason: collision with root package name */
    int f17882c;

    /* renamed from: d  reason: collision with root package name */
    ConnectionTelemetryConfiguration f17883d;

    public zzj() {
    }

    zzj(Bundle bundle, Feature[] featureArr, int i2, ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.f17880a = bundle;
        this.f17881b = featureArr;
        this.f17882c = i2;
        this.f17883d = connectionTelemetryConfiguration;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17880a, false);
        a.a(parcel, 2, (T[]) this.f17881b, i2, false);
        a.a(parcel, 3, this.f17882c);
        a.a(parcel, 4, (Parcelable) this.f17883d, i2, false);
        a.a(parcel, a2);
    }
}
