package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new ar();

    /* renamed from: a  reason: collision with root package name */
    private final int f17768a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17769b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17770c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17771d;

    /* renamed from: e  reason: collision with root package name */
    private final int f17772e;

    public RootTelemetryConfiguration(int i2, boolean z2, boolean z3, int i3, int i4) {
        this.f17768a = i2;
        this.f17769b = z2;
        this.f17770c = z3;
        this.f17771d = i3;
        this.f17772e = i4;
    }

    public int a() {
        return this.f17771d;
    }

    public int b() {
        return this.f17772e;
    }

    public int c() {
        return this.f17768a;
    }

    public boolean d() {
        return this.f17769b;
    }

    public boolean e() {
        return this.f17770c;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, c());
        a.a(parcel, 2, d());
        a.a(parcel, 3, e());
        a.a(parcel, 4, a());
        a.a(parcel, 5, b());
        a.a(parcel, a2);
    }
}
