package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new ac();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f18081a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f18082b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f18083c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f18084d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f18085e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f18086f;

    public LocationSettingsStates(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f18081a = z2;
        this.f18082b = z3;
        this.f18083c = z4;
        this.f18084d = z5;
        this.f18085e = z6;
        this.f18086f = z7;
    }

    public final boolean a() {
        return this.f18081a;
    }

    public final boolean b() {
        return this.f18084d;
    }

    public final boolean c() {
        return this.f18082b;
    }

    public final boolean d() {
        return this.f18085e;
    }

    public final boolean e() {
        return this.f18083c;
    }

    public final boolean f() {
        return this.f18086f;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, a());
        a.a(parcel, 2, c());
        a.a(parcel, 3, e());
        a.a(parcel, 4, b());
        a.a(parcel, 5, d());
        a.a(parcel, 6, f());
        a.a(parcel, a2);
    }
}
