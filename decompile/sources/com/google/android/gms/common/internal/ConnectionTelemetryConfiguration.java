package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new bc();

    /* renamed from: a  reason: collision with root package name */
    private final RootTelemetryConfiguration f17737a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17738b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17739c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f17740d;

    /* renamed from: e  reason: collision with root package name */
    private final int f17741e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f17742f;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z2, boolean z3, int[] iArr, int i2, int[] iArr2) {
        this.f17737a = rootTelemetryConfiguration;
        this.f17738b = z2;
        this.f17739c = z3;
        this.f17740d = iArr;
        this.f17741e = i2;
        this.f17742f = iArr2;
    }

    public int a() {
        return this.f17741e;
    }

    public boolean b() {
        return this.f17738b;
    }

    public boolean c() {
        return this.f17739c;
    }

    public int[] d() {
        return this.f17740d;
    }

    public int[] e() {
        return this.f17742f;
    }

    public final RootTelemetryConfiguration f() {
        return this.f17737a;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, (Parcelable) this.f17737a, i2, false);
        a.a(parcel, 2, b());
        a.a(parcel, 3, c());
        a.a(parcel, 4, d(), false);
        a.a(parcel, 5, a());
        a.a(parcel, 6, e(), false);
        a.a(parcel, a2);
    }
}
